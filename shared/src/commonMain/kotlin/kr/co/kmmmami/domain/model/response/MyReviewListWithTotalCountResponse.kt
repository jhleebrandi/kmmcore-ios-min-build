package kr.co.kmmmami.domain.model.response

import dev.icerock.moko.parcelize.Parcelize
import dev.icerock.moko.parcelize.Parcelable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

@Serializable
data class MyReviewListWithTotalCountResponse(
    @SerialName( "data")
    val data: ReviewData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class ReviewData(
    @SerialName( "total_count")
    val totalCount: Int = 0,
    @SerialName( "reviews")
    val reviews: List<ReviewTotalData>,
)

@Parcelize
@Serializable
data class ReviewTotalData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "created_time")
    val createdTime: String = "",
    @SerialName( "type")
    val type: String = "",
    @SerialName( "text")
    val text: String = "",
    @SerialName( "product")
    val product: MyAlarmProductData? = null,
    @SerialName( "seller")
    val seller: ReviewSellerData? = null,
    @SerialName( "user")
    val user: ReviewUserData? = null,
    @SerialName( "is_liked")
    var isLiked: Boolean = false,
    @SerialName( "like_count")
    var likeCount: Int = 0,
    @SerialName( "point_status")
    val pointStatus: ReviewPointStatus? = null,
    @SerialName( "point_status_reason")
    val pointStatusReason: ReviewPointStatusReason? = null,
    @SerialName( "evaluation")
    val evaluation: ReviewEvaluation? = null,
    @SerialName( "images")
    val images: List<ReviewImageData>? = null,
    @SerialName( "comment_count")
    var commentCount: Int = 0,
    @SerialName( "comments")
    val commentList: List<CommentData> = emptyList(),
    @SerialName( "is_deletable")
    val isDeletable: Boolean = false,
    @SerialName( "is_modifiable")
    val isModifiable: Boolean = false,
    @SerialName( "photo_reviews")
    val photoReviewsList: List<ReviewImageData>? = emptyList(),
) : Parcelable

@Parcelize
@Serializable
data class MyReviewTotalProductData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "parent_id")
    val parentId: String = "",
    @SerialName( "option_name")
    val optionName: String? = null,
    @SerialName( "seller_id")
    val sellerId: String = "",
    @SerialName( "is_cloth")
    val isCloth: Boolean = false,
) : Parcelable

@Parcelize
@Serializable
data class ReviewUserData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "image_url")
    val imageUrl: String = "",
    @SerialName( "weight")
    val weight: Int = 0,
    @SerialName( "height")
    val height: Int = 0,
    @SerialName( "shirt_size")
    val shirtSize: String = "",
    @SerialName( "pants_size")
    val pantsSize: String = "",
    @SerialName( "footwear_size")
    val footwearSize: String = "",
) : Parcelable

@Parcelize
@Serializable
data class ReviewPointStatus(
    @SerialName( "code")
    val code: String = "",
    @SerialName( "name")
    val name: String = "",
) : Parcelable

@Parcelize
@Serializable
data class ReviewPointStatusReason(
    @SerialName( "code")
    val code: String = "",
    @SerialName( "text")
    val text: String = "",
) : Parcelable

@Parcelize
@Serializable
data class ReviewEvaluation(
    @SerialName( "satisfaction")
    val satisfaction: Int = 0,
    @SerialName( "wearing_sensation_code")
    val wearingSensationCode: String = "",
    @SerialName( "wearing_sensation")
    val wearingSensation: String = "",
) : Parcelable

@Parcelize
@Serializable
data class ReviewImageData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "image_thumbnail_url")
    val thumbnailUrl: String = "",
    @SerialName( "image_medium_url")
    val mediumUrl: String = "",
    @SerialName( "image_url")
    val imageUrl: String = "",
    @SerialName( "image_thumb_url") // 유저의 다른 리뷰 보기에서 사용된다....안타깝다.
    val imageThumbUrl: String = "",
) : Parcelable
