package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * SMS email 코드 검증
 * @author gon (leeyg@brandi.co.kr)
 * @since 1/4/21.
 **/
@Serializable
data class VerifyCodeResponse(
    @SerialName( "data")
    val data: CertificationIdData,
    @SerialName( "meta")
    override val meta: Meta?,
) : Response()

@Serializable
data class CertificationIdData(
    @SerialName( "certification_id")
    val certificationId: String,
)
