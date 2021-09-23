package kr.co.kmmmami.core_data.model

import kr.co.kmmmami.core_data.FindErrorCode

sealed class ResultData<out T : Any> {
    data class Success<out T : Any>(val data: T?) : ResultData<T>()

    // 제너릭을 쓰거나 val data: Any? = null, 형태로 데이터를 넘겨야 함.
//    data class LocalSuccess<out T : Any>(val data: T?) : ResultData<T>()

    data class Error(
        val exception: Exception? = null,
        val meta: Meta? = null,
        val code: String? = null,
        private val message: String? = null,
        val data: Any? = null,
        val type: ERROR_TYPE = ERROR_TYPE.NONE,
    ) : ResultData<Nothing>() {

        fun getMessage(): String {
            message?.let {
                return message
            }
            return FindErrorCode.getErrorResponse(-1)
        }
    }
}

enum class ERROR_TYPE {
    LOGOUT,
    MAINTENANCE,
    ANOTHER_SERVICE_MEMBER,
    NONE
}
