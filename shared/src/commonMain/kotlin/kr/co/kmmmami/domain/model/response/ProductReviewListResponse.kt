package kr.co.kmmmami.domain.model.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response
import kr.co.kmmmami.domain.model.PhotoReviewData
import kr.co.kmmmami.domain.model.PhotoReviewListData
import kr.co.kmmmami.domain.model.TextReviewListData

@Serializable
data class ProductReviewListResponse(
    @SerialName( "meta")
    override val meta: Meta? = null,
    @SerialName( "data")
    val data: ProductReviewListData? = null,
) : Response()

@Serializable
data class ProductReviewListData(
    @SerialName( "is_cloth")
    val isCloth: Boolean = false, // true
    @SerialName( "top_photo_reviews")
    val topPhotoReviewList: List<PhotoReviewData> = emptyList(),
    @SerialName( "photo_reviews")
    val photoReviewListData: PhotoReviewListData? = null,
    @SerialName( "text_reviews")
    val textReviewListData: TextReviewListData? = null,
)
