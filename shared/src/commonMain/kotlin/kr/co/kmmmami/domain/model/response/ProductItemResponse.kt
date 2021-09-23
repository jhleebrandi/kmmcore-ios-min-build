package kr.co.kmmmami.domain.model.response

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */

@Serializable
data class ProductItemResponse(
    @SerialName( "data")
    val data: ProductItemData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Parcelize
@Serializable
data class ProductItemData(
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
    @SerialName( "is_purchased")
    val isPurchased: Boolean = false,
    @SerialName( "video_url")
    val videoUrl: String = "",
    @SerialName( "is_new")
    val isNew: Boolean = false,
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
    val originalPoint: Int = 0,
    @SerialName( "sale_price")
    val salePrice: String = "",
    @SerialName( "sale_percent")
    val salePercent: Int = 0,
    @SerialName( "original_sale_price")
    val originalSalePrice: String = "",
    @SerialName( "original_sale_percent")
    val originalSalePercent: Int = 0,
    @SerialName( "popular_category_id")
    val popularCategoryId: String = "",
    @SerialName( "popular_category_name")
    val popularCategoryName: String = "",
    @SerialName( "popular_category_products")
    val popularCategoryProductList: List<ProductData> = emptyList(),
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
    @SerialName( "relatation_products")
    val relationProductList: List<ProductData> = emptyList(),
    @SerialName( "add_info")
    val addInfoList: List<AddInfoData> = emptyList(),
    @SerialName( "tags")
    val tagList: List<ProductItemTagData> = emptyList(),
    @SerialName( "seller")
    val seller: ProductItemSellerData? = null,
    @SerialName( "is_all_free_delivery")
    val isAllFreeDelivery: Boolean = false,
) : Parcelable {

    @Transient
    var leftTime: Long = 0

    fun getProductSalePrice(): String {
        if (originalSalePrice.isEmpty()) {
            return salePrice
        }
        return if (isNew && leftTime > 0) {
            salePrice
        } else {
            originalSalePrice
        }
    }
}

@Parcelize
@Serializable
data class CategoryIdData(
    @SerialName( "id")
    val id: String = "",
) : Parcelable

@Parcelize
@Serializable
data class ProductItemImageData(
    @SerialName( "image_thumbnail_url")
    val thumbnailUrl: String = "",
    @SerialName( "image_url")
    val imageUrl: String = "",
    @SerialName( "image_medium_url")
    val mediumImageUrl: String = "",
) : Parcelable

@Parcelize
@Serializable
data class OptionData(
    @SerialName( "product_id")
    val productId: String = "",
    @SerialName( "sku")
    val sku: String = "",
    @SerialName( "qty")
    val qty: Long = 0L,
    @SerialName( "min_order_qty")
    val minimumOrderQty: Long = 0L,
    @SerialName( "max_order_qty")
    val maximumOrderQty: Long = 0L,
    @SerialName( "add_price")
    val addPrice: String = "",
    @SerialName( "is_sell")
    val isSell: Boolean = false,
    @SerialName( "is_essential")
    val isEssential: Boolean = false,
    @SerialName( "is_sold_out")
    val isSoldOut: Boolean = false,
    @SerialName( "attributes")
    val attributeList: List<AttributeData> = emptyList(),
    @SerialName( "cartQty")
    val cartQty: Long = 0L,
) : Parcelable

@Parcelize
@Serializable
data class ProductItemCategoryHierarchyData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "level")
    val level: String = "",
    @SerialName( "name_kor")
    val koreanName: String = "",
) : Parcelable

@Parcelize
@Serializable
data class AddInfoData(
    @SerialName( "key")
    val key: String = "",
    @SerialName( "text")
    val text: String = "",
) : Parcelable

@Parcelize
@Serializable
data class ProductItemTagData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
) : Parcelable

@Parcelize
@Serializable
data class ProductItemSellerData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "en_name")
    val englishName: String = "",
    @SerialName( "operation_time")
    val operationTime: String? = "",
    @SerialName( "telephone")
    val telephone: String? = "",
    @SerialName( "kakao_talk_id")
    val kakaoTalkId: String? = "",
    @SerialName( "kakao_yellow_id")
    val kakaoYellowId: String? = "",
    @SerialName( "address1")
    val address: String? = "",
    @SerialName( "address2")
    val remainingAddress: String = "",
    @SerialName( "text")
    val text: String = "",
    @SerialName( "image_url")
    val imageUrl: String = "",
    @SerialName( "tags")
    val tagList: List<ProductItemTagData> = emptyList(),
    @SerialName( "products")
    val productList: List<ProductData> = emptyList(),
    @SerialName( "best_products")
    val bestProducts: List<ProductData> = emptyList(),
    @SerialName( "is_bookmark")
    val isBookMark: Boolean = false,
    @SerialName( "user_id")
    val userId: String = "",
    @SerialName( "instagram_id")
    val instagramId: String? = "",
    @SerialName( "background_image_url")
    val backgroundImageUrl: String = "",
    @SerialName( "bookmark_count")
    val bookMarkCount: Int = 0,
    @SerialName( "detail_text")
    val detailText: String? = "",
    @SerialName( "model_info")
    val modelInfoList: List<AddInfoData> = emptyList(),
    @SerialName( "delivery_text")
    val deliveryText: String? = "",
    @SerialName( "exchange_text")
    val exchangeText: String? = "",
    @SerialName( "product_count")
    val productCount: Int = 0,
    @SerialName( "email")
    val email: String = "",
    @SerialName( "business_info")
    val businessInfo: BusinessInfoData? = null,
    @SerialName( "type")
    val type: SellerTypeData? = null,
    @SerialName( "is_partner")
    val isPartner: Boolean = false,
) : Parcelable

@Parcelize
@Serializable
data class AttributeData(
    @SerialName( "title")
    val title: String = "",
    @SerialName( "value")
    var value: String = "",
    @SerialName( "order")
    val order: Int = 0,
    @SerialName( "optionsEntity")
    val option: OptionData? = null,
) : Parcelable

@Parcelize
@Serializable
data class BusinessInfoData(
    @SerialName( "business_name")
    val businessName: String = "",
    @SerialName( "business_code")
    val businessCode: String = "",
    @SerialName( "representative_name")
    val representativeName: String = "",
    @SerialName( "mail_order_business_code")
    val mailOrderBusinessCode: String = "",
) : Parcelable

@Parcelize
@Serializable
data class SellerTypeData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "group_id")
    val groupId: String = "",
    @SerialName( "group_name")
    val groupName: String = "",
) : Parcelable
