package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */
@Serializable
data class MainCategoryListResponse(
    @SerialName( "data")
    val dataList: List<MainCategoryListData>? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class MainCategoryListData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "image_thumbnail_url")
    val thumbnailUrl: String = "",
    @SerialName( "image_medium_url")
    val mediumImageUrl: String = "",
    @SerialName( "image_url")
    val imageUrl: String = "",
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
    @SerialName( "free_delivery_yn")
    val freeDeliveryYn: String = "",
    @SerialName( "seller")
    val seller: MainCategorySellerData? = null,
)

@Serializable
data class MainCategorySellerData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "image_url")
    val imageUrl: String = "",
    @SerialName( "text")
    val text: String = "",
)
