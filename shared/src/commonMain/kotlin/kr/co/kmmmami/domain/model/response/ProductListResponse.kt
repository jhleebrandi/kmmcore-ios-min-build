package kr.co.kmmmami.domain.model.response

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */
@Serializable
data class ProductListResponse(
    @SerialName( "data")
    val dataList: List<ProductData>? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Parcelize
@Serializable
data class ProductData(
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
    @SerialName( "is_bookmark")
    val isBookMark: Boolean = false,
    @SerialName( "is_delete")
    val isDelete: Boolean = false,
    @SerialName( "seller")
    val seller: ProductListSellerData? = null,
    @SerialName( "is_free_delivery")
    val isFreeDelivery: Boolean = false,
    @SerialName( "rank")
    val rank: String? = null,
    @SerialName( "is_purchased")
    val isPurchased: Boolean = false,
    @SerialName( "updateTm")
    val updateTime: Long = 0L,
    @SerialName( "tagName")
    val tagName: String = "",
) : Parcelable {
    @SerialName( "isDbBookMark")
    var isDbBookMark: Boolean = false

    fun asCacheData(): ProductItemSection1Data {
        return ProductItemSection1Data(
            id = this.id,
            name = this.name,
            thumbnailUrl = this.thumbnailUrl,
            imageList = arrayListOf(ProductItemImageData(this.thumbnailUrl, this.thumbnailUrl, this.thumbnailUrl)),
            price = this.price.toString(),
            isSell = this.isSell,
            isPurchased = this.isPurchased,
            isBookMark = this.isBookMark,
            seller = this.seller?.asCacheData(),
            salePrice = this.salePrice,
            salePercent = this.salePercent,
            originalSalePercent = this.salePercent,
            originalSalePrice = this.salePrice.toString(),
            isAllFreeDelivery = true,
        )
    }
}

@Parcelize
@Serializable
data class ProductListSellerData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "image_url")
    val imageUrl: String = "",
    @SerialName( "text")
    val text: String = "",
    @SerialName( "bookmark_count")
    val bookMarkCount: String = "",
    @SerialName( "type")
    val type: SellerTypeData? = null,
) : Parcelable {
    fun asCacheData(): ProductItemSellerData {
        return ProductItemSellerData(
            id = this.id,
            name = this.name,
            text = this.text,
            imageUrl = this.imageUrl,
            bookMarkCount = this.bookMarkCount.toIntOrNull() ?: 0,
            type = this.type,
        )
    }
}
