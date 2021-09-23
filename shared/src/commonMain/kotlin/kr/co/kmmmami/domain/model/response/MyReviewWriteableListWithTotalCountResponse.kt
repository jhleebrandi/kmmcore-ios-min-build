package kr.co.kmmmami.domain.model.response

import dev.icerock.moko.parcelize.Parcelize
import dev.icerock.moko.parcelize.Parcelable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

@Serializable
data class MyReviewWriteableListWithTotalCountResponse(
    @SerialName( "data")
    val data: ReviewWriteableData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class ReviewWriteableData(
    @SerialName( "total_count")
    val totalCount: Int = 0,
    @SerialName( "order_details")
    val orderDetails: List<OrderDetailData>,
)

@Serializable
data class OrderDetailData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "code")
    val code: String = "",
    @SerialName( "created_time")
    val createdTime: String = "",
    @SerialName( "order_completed_time")
    val orderCompletedTime: String = "",
    @SerialName( "text")
    val text: ReviewTextData? = null,
    @SerialName( "seller")
    val seller: ReviewSellerData? = null,
    @SerialName( "product")
    val product: ReviewProductData? = null,
)

@Serializable
data class ReviewTextData(
    @SerialName( "head")
    val head: String = "",
    @SerialName( "content")
    val content: String = "",
)

@Parcelize
@Serializable
data class ReviewSellerData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "image_url")
    val imageUrl: String = "",
    @SerialName( "is_partner")
    val isPartner: Boolean = false,
    @SerialName( "type")
    val type: TypeData? = null,
    @SerialName( "section_group")
    val sectionGroup: TypeData? = null,
) : Parcelable

@Serializable
data class ReviewProductData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "image_thumbnail_url")
    val thumbnailUrl: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "option_name")
    val optionName: String = "",
    @SerialName( "parent_id")
    val parentId: String = "",
    @SerialName( "is_cloth")
    val isCloth: Boolean = false,
)

@Parcelize
@Serializable
data class TypeData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
) : Parcelable
