package kr.co.kmmmami.domain.model.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response
import kr.co.kmmmami.domain.model.PhotoReviewData

/**
 * Created by leest@brandi.co.kr on 2021/1/8
 */
@Serializable
data class PhotoReviewListFirstResponse(
    @SerialName( "meta")
    override val meta: Meta? = null,
    @SerialName( "data")
    val data: PhotoReviewFirstData? = null,
) : Response()

@Serializable
data class PhotoReviewFirstData(
    @SerialName( "is_cloth")
    val isCloth: Boolean = false,
    @SerialName( "total_count")
    val totalCount: Int = 0,
    @SerialName( "reviews")
    val reviewList: List<PhotoReviewData> = emptyList()
)
