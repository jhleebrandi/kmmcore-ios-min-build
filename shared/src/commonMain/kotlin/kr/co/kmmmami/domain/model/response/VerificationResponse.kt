package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by jangsc@brandi.co.kr on 12/16/20
 */
@Serializable
data class VerificationResponse(
    @SerialName( "data")
    val data: VersionData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class VerificationData(
    @SerialName( "name")
    val name: String = "",
    @SerialName( "is_joined")
    val isJoined: Boolean = false,
    @SerialName( "type")
    val type: String = "",
)
