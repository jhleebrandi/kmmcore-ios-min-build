package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by gwaksk@brandi.co.kr on 2021/02/24.
 */
@Serializable
data class AuthSNSInfoResponse(
    @SerialName( "meta")
    override val meta: Meta? = null,
    @SerialName( "data")
    val data: List<AuthSNSInfoData>? = null,
) : Response()

@Serializable
data class AuthSNSInfoData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "sns_id")
    val snsId: String = "",
    @SerialName( "sns_common_id")
    val snsCommonId: String = "",
    @SerialName( "type")
    val type: AuthSNSTypeData? = null,
)

@Serializable
data class AuthSNSTypeData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "en_name")
    val enName: String = "",
)
