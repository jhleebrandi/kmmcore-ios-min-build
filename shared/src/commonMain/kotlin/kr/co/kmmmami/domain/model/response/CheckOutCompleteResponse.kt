package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response
import kr.co.kmmmami.domain.model.SettlementData

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */
@Serializable
data class CheckOutCompleteResponse(
    @SerialName( "data")
    val data: CheckOutCompleteData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class CheckOutCompleteData(
    @SerialName( "order_id")
    val orderId: String = "",
    @SerialName( "order_cd")
    val orderCd: String = "",
    @SerialName( "total_product_price")
    val totalProductPrice: Long = 0L,
    @SerialName( "total_delivery_price")
    val totalDeliveryPrice: Long = 0L,
    @SerialName( "discount_point")
    val discountPoint: Long = 0L,
    @SerialName( "settlement_price")
    val settlementPrice: Long = 0L,
    @SerialName( "saving_point")
    val savingPoint: Long = 0L,
    @SerialName( "discount_coupon_price")
    val discountCouponPrice: Long = 0L,
    @SerialName( "order_details")
    val orderDetailList: List<CheckoutCompleteOrderDetailData> = emptyList(),
    @SerialName( "settlement")
    val settlement: SettlementData? = null,
    @SerialName( "point_benefits")
    val pointBenefits: PointBenefitsData? = null,
    @SerialName( "photo_review_point_guide")
    val photoReviewPointGuide: String = "",
    @SerialName( "is_first_purchase")
    val isFirstPurchase: Boolean = false,
)

@Serializable
data class CheckoutCompleteOrderDetailData(
    @SerialName( "id")
    val id: String? = null,
    @SerialName( "code")
    val code: String? = null,
    @SerialName( "product")
    val product: OrderDetailProductData? = null,
    @SerialName( "seller")
    val seller: OrderDetailSellerData? = null,
    @SerialName( "created_time")
    val createdTime: String? = null,
)

@Serializable
data class OrderDetailProductData(
    @SerialName( "category_hierarchies")
    val categoryHierarchyList: List<ProductItemCategoryHierarchyData> = emptyList(),
    @SerialName( "category_id")
    val categoryIdList: List<CategoryId> = emptyList(),
    @SerialName( "id")
    val id: String? = null,
    @SerialName( "image_thumbnail_url")
    val thumbnailUrl: String? = null,
    @SerialName( "is_essential")
    val isEssential: Boolean? = null,
    @SerialName( "name")
    val name: String? = null,
    @SerialName( "option_add_price")
    val optionAddPrice: Long = 0L,
    @SerialName( "option_name")
    val optionName: String? = null,
    @SerialName( "option_type")
    val optionType: String? = null,
    @SerialName( "parent_id")
    val parentId: String? = null,
    @SerialName( "qty")
    val qty: Long = 0L,
    @SerialName( "sale_price")
    val salePrice: Long = 0L
)

@Serializable
data class OrderDetailSellerData(
    @SerialName( "id")
    val id: String? = null,
    @SerialName( "name")
    val name: String? = null,
    @SerialName( "type")
    val type: Type? = null,
)

@Serializable
data class Type(
    @SerialName( "group_id")
    val groupId: String? = null,
    @SerialName( "group_name")
    val groupName: String? = null,
    @SerialName( "id")
    val id: String? = null,
    @SerialName( "name")
    val name: String? = null,
)

@Serializable
data class CategoryId(
    @SerialName( "id")
    val id: String? = null,
)

@Serializable
data class PointBenefitsData(
    @SerialName( "max_benefits_point")
    val maximumBenefitsPoint: String = "",
    @SerialName( "photo_review_point")
    val photoReviewPoint: String = "",
    @SerialName( "saving_point")
    val savingPoint: String = "",
    @SerialName( "text_review_point")
    val textReviewPoint: String = "",
)
