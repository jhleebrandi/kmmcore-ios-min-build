package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */
@Serializable
data class InquiriesListResponse(
    @SerialName( "data")
    val dataList: List<InquiriesData>? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class InquiriesData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "user")
    val user: InquiriesUserData? = null,
    @SerialName( "answer")
    val answer: AnswerData? = null,
    @SerialName( "product")
    val product: InquiriesProductData? = null,
    @SerialName( "text")
    val text: String = "",
    @SerialName( "created_time")
    val createdTime: Long = 0L
)

@Serializable
data class InquiriesUserData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
)

@Serializable
data class AnswerData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "seller")
    val seller: ProductListSellerData? = null,
    @SerialName( "text")
    val text: String = "",
    @SerialName( "is_secret")
    val isSecret: Boolean = false,
    @SerialName( "created_time")
    val createdTime: Long = 0L,
    @SerialName( "isVisible")
    val isVisible: Boolean = false,
)

@Serializable
data class InquiriesProductData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "image_thumbnail_url")
    val thumbnailUrl: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "price")
    val price: Long = 0L,
    @SerialName( "sale_price")
    val salePrice: Long = 0L,
    @SerialName( "sale_percent")
    val salePercent: Int = 0,
    @SerialName( "is_sell")
    val isSell: Boolean = false,
    @SerialName( "is_delete")
    val isDelete: Boolean = false,
)
