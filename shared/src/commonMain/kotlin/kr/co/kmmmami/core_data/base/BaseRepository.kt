package kr.co.kmmmami.core_data.base

import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kr.co.kmmmami.core_data.FindErrorCode
import kr.co.kmmmami.core_data.model.ERROR_TYPE
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.core_data.model.RootData
import kr.co.kmmmami.core_data.model.error.AnotherServiceMemberResponse
import kr.co.kmmmami.core_data.model.error.MaintenanceResponse

suspend inline fun <reified T : Any> safeApiCallFlow(
    call: suspend () -> HttpResponse,
): ResultData<T> {
    try {
        val json = Json {
            encodeDefaults = true
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
            coerceInputValues = true
        }
        val response = call.invoke()
        val code = response.status.value
        if (code == 200) {
            try {
                var jsonString: String = response.receive()

                // API에서 타입 null 이 되지 않는 경우가 있어서 string으로 받은 후 이를 예외처리 추가함.
                if (jsonString!!.contains("\"data\":[]")) {
                    jsonString = jsonString.replace("[]", "null")
                }
                if (jsonString.contains("\"data\":{}")) {
                    jsonString = jsonString.replace("{}", "null")
                }
                val rootData = json.decodeFromString<RootData>(jsonString)

                val errorCode = rootData?.meta?.getErrorCodeData() ?: 0

                if (FindErrorCode.isMaintenance(errorCode)) {
                    val maintenanceData = json.decodeFromString<MaintenanceResponse>(jsonString)
                    return ResultData.Error(
                        meta = rootData?.meta,
                        type = ERROR_TYPE.MAINTENANCE,
                        data = maintenanceData?.data
                    )
                } else {
                    val data = json.decodeFromString<T>(jsonString)
                    return ResultData.Success(data)
                }
            } catch (e: Exception) {
                val errorCode = -2
                val message = FindErrorCode.getErrorResponse(errorCode)
                return ResultData.Error(
                    code = errorCode.toString(),
                    message = message,
                    exception = e
                )
            }
        } else {
            val errorJson: String = response.receive()
            try {
                val rootData = json.decodeFromString<RootData>(errorJson)

                val errorCode = rootData?.meta?.getErrorCodeData() ?: 0
                val errorMessage =
                    FindErrorCode.getErrorResponse(errorCode, rootData?.meta?.errorMessage)

                // 키 만료
                if (FindErrorCode.isAuthKeyExpire(errorCode)) {
                    return ResultData.Error(
                        meta = rootData?.meta,
                        type = ERROR_TYPE.LOGOUT
                    )
                }
                // 다른 서비스 사용자
                else if (FindErrorCode.isAnotherServiceMember(errorCode)) {
                    val anotherServiceMemberData = json.decodeFromString<AnotherServiceMemberResponse>(errorJson)

                    return ResultData.Error(
                        code = errorCode.toString(),
                        message = errorMessage,
                        type = ERROR_TYPE.ANOTHER_SERVICE_MEMBER,
                        data = anotherServiceMemberData
                    )
                } else {
                    return ResultData.Error(
                        code = errorCode.toString(),
                        message = errorMessage,
                        meta = rootData?.meta
                    )
                }
            } catch (e: Exception) {
                val errorCode = -2
                val message = FindErrorCode.getErrorResponse(errorCode)
                return ResultData.Error(
                    code = errorCode.toString(),
                    message = message,
                    exception = e
                )
            }
            return ResultData.Error()
        }
    } catch (e: Exception) {
        val code = 0
        val message = FindErrorCode.getErrorResponse(code)
        e.printStackTrace()
        return ResultData.Error(
            message = message,
            exception = e
        )
    } finally {
        //
    }
}
