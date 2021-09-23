package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response
import kr.co.kmmmami.domain.model.TextReviewData

/**
 * Created by jangsc@brandi.co.kr on 12/16/20
 */
@Serializable
data class TextReviewListFirstResponse(
    @SerialName( "meta")
    override val meta: Meta? = null,
    @SerialName( "data")
    val data: TextReviewFirstData? = null,
) : Response()

@Serializable
data class TextReviewFirstData(
    @SerialName( "is_cloth")
    val isCloth: Boolean = false,
    @SerialName( "total_count")
    val totalCount: Int = 0,
    @SerialName( "reviews")
    val reviewList: List<TextReviewData> = emptyList()
)
