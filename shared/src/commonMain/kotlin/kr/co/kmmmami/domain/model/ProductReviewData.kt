package kr.co.kmmmami.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by kdy3@brandi.co.kr on 2021/03/15
 *
 * 리뷰 관련 모델
 */

@Serializable
data class PhotoReviewListData(
    @SerialName("total_count")
    val totalCount: Int = 0, // 10
    @SerialName("reviews")
    val reviewList: List<PhotoReviewData> = emptyList(),
)

@Serializable
data class PhotoReviewData(
    @SerialName("id")
    val id: String = "", // 7216773
    @SerialName("created_time")
    val createdTime: String = "", // 1615094775
    @SerialName("type")
    val type: String = "", // photo
    @SerialName("text")
    val text: String = "", // 기장도 좋고 다음에도 꼭 좋은제품 구매할겁니다!
    @SerialName("like_count")
    val likeCount: Int = 0, // 0
    @SerialName("comment_count")
    val commentCount: Int = 0, // 1
    @SerialName("is_liked")
    val isLiked: Boolean = false, // false
    @SerialName("product")
    val product: ReviewProductData? = null,
    @SerialName("user")
    val user: ReviewUserData? = null,
    @SerialName("evaluation")
    val evaluation: ReviewEvaluationData? = null,
    @SerialName("images")
    val imageList: List<ReviewImageData>? = null,
)

@Serializable
data class TextReviewListData(
    @SerialName("total_count")
    val totalCount: Int = 0, // 18
    @SerialName("reviews")
    val reviewList: List<TextReviewData> = emptyList(),
)

@Serializable
data class TextReviewData(
    @SerialName("id")
    val id: String = "", // 7242306
    @SerialName("created_time")
    val createdTime: String = "", // 1615336557
    @SerialName("type")
    val type: String = "", // text
    @SerialName("text")
    val text: String = "", // 이쁩니당
    @SerialName("like_count")
    val likeCount: Int = 0, // 0
    @SerialName("comment_count")
    val commentCount: Int = 0, // 0
    @SerialName("is_liked")
    val isLiked: Boolean = false, // false
    @SerialName("product")
    val product: ReviewProductData? = null,
    @SerialName("user")
    val user: ReviewUserData? = null,
    @SerialName("evaluation")
    val evaluation: ReviewEvaluationData? = null,
)

@Serializable
data class ReviewProductData(
    @SerialName("id")
    val id: String = "", // 19084905
    @SerialName("parent_id")
    val parentId: String = "", // 14582616
    @SerialName("option_name")
    val optionName: String = "", // 베이지/L
    @SerialName("seller_id")
    val sellerId: String = "", // 15785
)

@Serializable
data class ReviewUserData(
    @SerialName("id")
    val id: String = "", // 2360222
    @SerialName("name")
    val name: String = "", // scott2244
    @SerialName("image_url")
    val imageUrl: String = "", // http://image.brandi.me/user/empty_profile_210108.jpg
    @SerialName("weight")
    val weight: Int = 0,
    @SerialName("height")
    val height: Int = 0, // 0
    @SerialName("shirt_size")
    val shirtSize: String = "", // 00
    @SerialName("pants_size")
    val pantsSize: String = "", // 00
    @SerialName("footwear_size")
    val footwearSize: String = "", // 00
)

@Serializable
data class ReviewEvaluationData(
    @SerialName("satisfaction")
    val satisfaction: String = "", // 0
    @SerialName("wearing_sensation_code")
    val wearingSensationCode: String = "", // 00
    @SerialName("wearing_sensation")
    val wearingSensation: String = "", // 해당 없음
)

@Serializable
data class ReviewImageData(
    @SerialName("id")
    val id: Int = 0, // 4486132
    @SerialName("image_thumbnail_url")
    val imageThumbnailUrl: String = "", // http://image.brandi.me/media/2021/03/07/2360222_1615094775_image1_S.jpg
    @SerialName("image_medium_url")
    val imageMediumUrl: String = "", // http://image.brandi.me/media/2021/03/07/2360222_1615094775_image1_M.jpg
    @SerialName("image_url")
    val imageUrl: String = "", // http://image.brandi.me/media/2021/03/07/2360222_1615094775_image1_L.jpg
)
