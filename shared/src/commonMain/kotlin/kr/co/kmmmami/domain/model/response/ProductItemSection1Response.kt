package kr.co.kmmmami.domain.model.response

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response
import kr.co.kmmmami.domain.model.OptionProductData

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */
@Serializable
data class ProductItemSection1Response(
    @SerialName( "data")
    val data: ProductItemSection1Data? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Parcelize
@Serializable
data class ProductItemSection1Data(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "image_thumbnail_url")
    val thumbnailUrl: String = "",
    @SerialName( "price")
    val price: String = "0",
    @SerialName( "is_sell")
    val isSell: Boolean = false,
    @SerialName( "is_partner")
    val isPartner: Boolean = false,
    @SerialName( "is_purchased")
    val isPurchased: Boolean = false,
    @SerialName( "video_url")
    val videoUrl: String = "",
    @SerialName( "is_new")
    var isNew: Boolean = false,
    @SerialName( "start_time")
    val startTime: Long = 0L,
    @SerialName( "end_time")
    val endTime: Long = 0L,
    @SerialName( "is_special_price")
    val isSpecialPrice: Boolean = false,
    @SerialName( "category_id")
    val categoryIdList: List<CategoryIdData> = emptyList(),
    @SerialName( "memo")
    val memo: String = "",
    @SerialName( "delivery_price")
    val deliveryPrice: String = "",
    @SerialName( "free_delivery_price")
    val freeDeliveryPrice: String = "",
    @SerialName( "inquiry_count")
    val inquiryCount: Int = 0,
    @SerialName( "point")
    val point: Long = 0L,
    @SerialName( "point_percent")
    val pointPercent: Float = 0f,
    @SerialName( "type")
    val type: String = "",
    @SerialName( "text")
    val text: String = "",
    @SerialName( "brand_id")
    val brandId: String = "",
    @SerialName( "is_bookmark")
    val isBookMark: Boolean = false,
    @SerialName( "simple_text")
    val simpleText: String = "",
    @SerialName( "bookmark_count")
    val bookMarkCount: Int = 0,
    @SerialName( "original_point")
    val originalPoint: Long = 0L,
    @SerialName( "original_sale_price")
    val originalSalePrice: String = "",
    @SerialName( "original_sale_percent")
    val originalSalePercent: Int = 0,
    @SerialName( "seller")
    val seller: ProductItemSellerData? = null,
    @SerialName( "is_genuine_certification")
    val isGenuineCertification: Boolean = false,
    @SerialName( "images")
    val imageList: List<ProductItemImageData> = emptyList(),
    @SerialName( "option_type")
    val optionType: String = "",
    @SerialName( "options")
    val optionList: ArrayList<OptionData> = arrayListOf(),
    @SerialName( "category_hierarchies")
    val categoryHierarchyList: List<ProductItemCategoryHierarchyData> = emptyList(),
    @SerialName( "coupons")
    val couponList: List<CouponData> = emptyList(),
    @SerialName( "is_coupon_download_completed")
    val isCouponDownloadCompleted: Boolean = false,
    @SerialName( "relatation_products")
    val relationProductList: List<ProductData> = emptyList(),
    @SerialName( "add_info")
    val addInfoList: List<AddInfoData> = emptyList(),
    @SerialName( "tags")
    val tagList: List<ProductItemTagData> = emptyList(),
    @SerialName( "is_all_free_delivery")
    val isAllFreeDelivery: Boolean = false,
    @SerialName( "sale_price")
    val salePrice: Long = 0L,
    @SerialName( "sale_percent")
    val salePercent: Int = 0,
) : Parcelable {

    fun getOptionType(): OptionType {
        return when (optionType) {
            "I" -> OptionType.I
            else -> OptionType.M
        }
    }

    enum class OptionType {
        M, // 일반, 조합분리
        I // 독립형
    }

    var leftTime: Long = 0

    fun getSalePrice(): String {
        if (originalSalePrice == null) {
            return salePrice.toString()
        }

        return if (isNew && leftTime > 0) {
            salePrice.toString()
        } else {
            originalSalePrice
        }
    }

    fun getSalePercent(): String {
        return if (isNew && leftTime > 0) {
            salePercent.toString()
        } else {
            originalSalePercent.toString()
        }
    }

    fun createOptionProductData(): OptionProductData {
        return OptionProductData(
            id = id,
            name = name,
            seller = seller,
            salePrice = salePrice,
            optionType = getOptionType(),
            optionList = optionList ?: emptyList(),
            categoryHierarchyList = categoryHierarchyList ?: emptyList(),
        )
    }
}
