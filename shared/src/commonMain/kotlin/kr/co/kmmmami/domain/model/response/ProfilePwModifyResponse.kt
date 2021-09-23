package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

@Serializable
data class ProfilePwModifyResponse(
    @SerialName("meta")
    override val meta: Meta? = null,

    @SerialName("data")
    val data:ProfilePwModifyData? = null
): Response()

@Serializable
data class ProfilePwModifyData(
    @SerialName("brandi_token")
    val brandiToken: String = ""
)
