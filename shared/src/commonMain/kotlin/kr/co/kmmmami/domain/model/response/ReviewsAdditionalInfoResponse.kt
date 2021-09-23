package kr.co.kmmmami.domain.model.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by kdy3@brandi.co.kr on 2021/03/17
 */
@Serializable
data class ReviewsAdditionalInfoResponse(
    @SerialName( "meta")
    override val meta: Meta? = null,
    @SerialName( "data")
    val data: ReviewsAdditionalInfoData? = null,
): Response()

@Serializable
data class ReviewsAdditionalInfoData(
    @SerialName( "is_cloth")
    val isCloth: Boolean = false,
)
