package kr.co.kmmmami.data.networking.api

import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.JsonObject
import kr.co.kmmmami.data.networking.KtorHttpClient
import kr.co.kmmmami.data.networking.NetworkingConstants.API_URL_HOST
import kr.co.kmmmami.domain.model.request.KidsRequest
import kr.co.kmmmami.domain.model.request.SignUpRequest
import kr.co.kmmmami.domain.model.request.UserSelfRequest

class LoginAPI(val ktorHttpClient: KtorHttpClient) {
    val httpClient = ktorHttpClient.client

    suspend fun getVersions(token: String): HttpResponse {
        return httpClient.get<HttpResponse>(API_URL_HOST.plus("versions"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun getUrls(token: String): HttpResponse {
        return httpClient.get<HttpResponse>(API_URL_HOST.plus("urls")) {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun getTexts(token: String): HttpResponse {
        return httpClient.get<HttpResponse>(API_URL_HOST.plus("texts")) {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun postMemberPush(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.post<HttpResponse>(API_URL_HOST.plus("users/push")) {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun deleteMemberPush(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.delete<HttpResponse>(API_URL_HOST.plus("users/push")) {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getUsersSelfDevices(token: String): HttpResponse {
        return httpClient.get<HttpResponse>(API_URL_HOST.plus("users/self/devices")) {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun getUsersSelf(token: String): HttpResponse {
        return httpClient.get<HttpResponse>(API_URL_HOST.plus("users/self")) {
            headers {
                append("Authorization", token)
            }
            parameter("version", "2102")
        }
    }

    suspend fun getUsersSelfMeta(token: String): HttpResponse {
        return httpClient.get<HttpResponse>(API_URL_HOST.plus("users/self/meta")) {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun getUserSelfRecommendCode(token: String): HttpResponse {
        return httpClient.get<HttpResponse>(API_URL_HOST.plus("users/self/recommend-code")) {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun postUserLogin(token: String, bodyData: Map<String, String>): HttpResponse {
        return httpClient.post<HttpResponse>(API_URL_HOST.plus("users/login")) {
            headers {
                append("Authorization", token)
            }
            parameter("type", "ew_device")
            parameter("version", "2010")

            body = bodyData
        }
    }

    suspend fun postDeleteMember(token: String, bodyData: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(API_URL_HOST.plus("users/delete")) {
            headers {
                append("Authorization", token)
            }
            parameter("version", "2010")

            body = bodyData
        }
    }

    suspend fun putUsersSelfPassword(token: String, bodyData: JsonObject): HttpResponse {
        return httpClient.put<HttpResponse>(API_URL_HOST.plus("users/self/password")) {
            headers {
                append("Authorization", token)
            }
            body = bodyData
        }
    }

    suspend fun postUsersModify(token: String, jsonBody: JsonObject, fileByteArray: ByteArray?, fileName: String = ""): HttpResponse {
        if (fileByteArray != null) {
            return httpClient.submitFormWithBinaryData(
                url = API_URL_HOST.plus("sers/modify"),
                formData = formData {
                    append("json", jsonBody.toString())
                    append("image", fileByteArray, Headers.build {
                        append(HttpHeaders.ContentType, "image/*")
                        append(HttpHeaders.ContentDisposition, fileName)
                    })
                }
            ) {
                headers {
                    append("Authorization", token)
                }
                parameter("version", "2010")
            }
        } else {
            return httpClient.submitForm(
                url = API_URL_HOST.plus("sers/modify"),
                formParameters = Parameters.build {
                    append("json", jsonBody.toString())
                },
                encodeInQuery = true
            ) {
                headers {
                    append("Authorization", token)
                }
                parameter("version", "2010")
            }
        }
    }

    suspend fun getMyReviews(token: String, userId: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(API_URL_HOST.plus("users/${userId}/reviews")) {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun postFindId(token: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(API_URL_HOST.plus("users/find-id")) {
            headers {
                append("Authorization", token)
            }
            parameter("type", "phone")
            body = jsonObject
        }
    }

    suspend fun postUsersFindPassword(token: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(API_URL_HOST.plus("uusers/find-password")) {
            headers {
                append("Authorization", token)
            }
            parameter("type", "phone")
            body = jsonObject
        }
    }

    suspend fun postFindIdByEmail(token: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(API_URL_HOST.plus("users/find-id")) {
            headers {
                append("Authorization", token)
            }
            parameter("type", "email")
            body = jsonObject
        }
    }

    suspend fun postUsersFindIdVerification(token: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(API_URL_HOST.plus("users/find-id/verification")) {
            headers {
                append("Authorization", token)
            }
            parameter("version", "2010")
            body = jsonObject
        }
    }

    suspend fun postUsersFindPasswordVerification(token: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(API_URL_HOST.plus("users/find-password/verification")) {
            headers {
                append("Authorization", token)
            }
            body = jsonObject
        }
    }

    suspend fun getUserNickname(token: String, nickname: String): HttpResponse {
        return httpClient.get<HttpResponse>(API_URL_HOST.plus("users/nickname/${nickname}")) {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun getUserEmail(token: String, email: String): HttpResponse {
        return httpClient.get<HttpResponse>(API_URL_HOST.plus("sers/email/${email}")) {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun getUsersRecommendCode(token: String, recommendCode: String): HttpResponse {
        return httpClient.get<HttpResponse>(API_URL_HOST.plus("users/recommend-code/${recommendCode}")) {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun postUsersSignUp(token: String, request: SignUpRequest, fileByteArray: ByteArray?, fileName: String = ""): HttpResponse {
        if (fileByteArray != null) {
            return httpClient.submitFormWithBinaryData(
                url = API_URL_HOST.plus("users/signup"),
                formData = formData {
                    append("json", request.toString())
                    append("image", fileByteArray, Headers.build {
                        append(HttpHeaders.ContentType, "image/*")
                        append(HttpHeaders.ContentDisposition, fileName)
                    })
                }
            ) {
                headers {
                    append("Authorization", token)
                }
                parameter("type", "id-verification")
                parameter("version", "2010")
            }
        } else {
            return httpClient.submitForm(
                url = API_URL_HOST.plus("sers/modify"),
                formParameters = Parameters.build {
                    append("json", request.toString())
                },
                encodeInQuery = true
            ) {
                headers {
                    append("Authorization", token)
                }
                parameter("type", "id-verification")
                parameter("version", "2010")
            }
        }
    }

    suspend fun postUserSelfService(token: String, userSelfRequest: UserSelfRequest): HttpResponse {
        return httpClient.post<HttpResponse>(API_URL_HOST.plus("users/self/service")) {
            headers {
                append("Authorization", token)
            }
            parameter("version", "2010")
            body = userSelfRequest
        }
    }

    suspend fun verifyPhone(token: String, certCode: String, refer: String?): HttpResponse {
        return httpClient.get<HttpResponse>(API_URL_HOST.plus("users/verification/${certCode}")) {
            headers {
                append("Authorization", token)
            }
            refer?.let {
                parameter("refer", it)
            }
        }
    }

    suspend fun verifyPhone(token: String, jsonObject: JsonObject, refer: String?): HttpResponse {
        return httpClient.post<HttpResponse>(API_URL_HOST.plus("users/verification/phone")) {
            headers {
                append("Authorization", token)
            }
            refer?.let {
                parameter("refer", it)
            }
            body = jsonObject
        }
    }

    suspend fun getSNSInfo(token: String): HttpResponse {
        return httpClient.get<HttpResponse>(API_URL_HOST.plus("users/sns/account")) {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun putSNSLinkOn(token: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.put<HttpResponse>(API_URL_HOST.plus("users/sns/account/on")) {
            headers {
                append("Authorization", token)
            }
            body = jsonObject
        }
    }

    suspend fun putSNSLinkOff(token: String, snsAccountId: String): HttpResponse {
        return httpClient.put<HttpResponse>(API_URL_HOST.plus("users/sns/account/${snsAccountId}/off")) {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun putTransformAccount(token: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.put<HttpResponse>(API_URL_HOST.plus("users/username/transform}/off")) {
            headers {
                append("Authorization", token)
            }
            parameter("version", "2010")
            body = jsonObject
        }
    }

    suspend fun getUserSnsBySocial(token: String, sns_type: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(API_URL_HOST.plus("users/sns/${sns_type}")) {
            headers {
                append("Authorization", token)
            }
            parameter("version", "2010")
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getUserSnsBySocial(token: String, sns_type: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.get<HttpResponse>(API_URL_HOST.plus("users/sns/${sns_type}")) {
            headers {
                append("Authorization", token)
            }
            parameter("version", "2010")
            body = jsonObject
        }
    }

    suspend fun postUserSnsBySocial(token: String, sns_type: String, map: Map<String, String>): HttpResponse {
        return httpClient.post<HttpResponse>(API_URL_HOST.plus("users/sns/${sns_type}")) {
            headers {
                append("Authorization", token)
            }
            parameter("version", "2010")
            body = map
        }
    }

    suspend fun putUsersSelfVerification(token: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.put<HttpResponse>(API_URL_HOST.plus("users/self/verification")) {
            headers {
                append("Authorization", token)
            }
            parameter("version", "2010")
            body = jsonObject
        }
    }

    suspend fun postMembersDevice(token: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(API_URL_HOST.plus("users/self/devices")) {
            headers {
                append("Authorization", token)
            }
            body = jsonObject
        }
    }

    suspend fun getKidsInfo(token: String): HttpResponse {
        return httpClient.post<HttpResponse>(API_URL_HOST.plus("users/kids")) {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun postKidsInfo(
        token: String,
        isConvert: Boolean = false,
        request: KidsRequest,
        fileByteArrayList: List<ByteArray>?,
        fileNameList: List<String>,
        ): HttpResponse {
        if (fileByteArrayList != null) {
            return httpClient.submitFormWithBinaryData(
                url = API_URL_HOST.plus("users/kids"),
                formData = formData {
                    append("json", request.toString())
                    fileByteArrayList.forEachIndexed { index, bytes ->
                        append("images[]", bytes, Headers.build {
                            append(HttpHeaders.ContentType, "image/*")
                            append(HttpHeaders.ContentDisposition, fileNameList?.getOrNull(index) ?: "")
                        })
                    }
                }
            ) {
                headers {
                    append("Authorization", token)
                }
                parameter("is-convert", isConvert)
                parameter("version", "2102")
            }
        } else {
            return httpClient.submitForm(
                url = API_URL_HOST.plus("users/kids"),
                formParameters = Parameters.build {
                    append("json", request.toString())
                },
                encodeInQuery = true
            ) {
                headers {
                    append("Authorization", token)
                }
                parameter("is-convert", isConvert)
                parameter("version", "2102")
            }
        }
    }
}
