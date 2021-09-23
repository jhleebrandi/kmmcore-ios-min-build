package kr.co.kmmmami.domain.model.response

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.domain.model.SectionGroupData
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */
@Serializable
data class DeliveryListResponse(
    @SerialName( "data")
    val dataList: List<DeliveryData>? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Parcelize
@Serializable
data class DeliveryData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "code")
    val code: String = "",
    @SerialName( "created_time")
    val createdTime: String = "",
    @SerialName( "settlement")
    val settlement: DeliveryListSettlementData? = null,
    @SerialName( "order_details")
    val orderDetailList: List<DeliveryListOrderDetailData> = emptyList(),
    @SerialName( "isRefund")
    val isRefund: Boolean = false,
    @SerialName( "is_Coupon")
    val isCoupon: Boolean = false,
    @SerialName( "discount_coupon_price")
    val discountCouponPrice: Long = 0L,
    @SerialName( "discount_point")
    val discountPoint: Long = 0L,
) : Parcelable

@Parcelize
@Serializable
data class DeliveryListSettlementData(
    @SerialName( "code")
    val code: String = "",
    @SerialName( "name")
    val name: String = "",
) : Parcelable

@Parcelize
@Serializable
data class DeliveryListOrderDetailData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "code")
    val code: String = "",
    @SerialName( "product")
    val product: DeliveryListProductData? = null,
    @SerialName( "delivery")
    val delivery: DeliveryListDeliveryData? = null,
    @SerialName( "seller")
    val seller: DeliveryListSellerData? = null,
    @SerialName( "buttons")
    val buttonList: List<String> = emptyList(),
    @SerialName( "cancel_possible_date")
    val cancelPossibleDate: String = "",
    @SerialName( "cancel_possible_date_text")
    val cancelPossibleDateText: String = "",
    @SerialName( "state")
    val state: Int = 0,
    @SerialName( "state_name")
    val stateName: String = "",
    @SerialName( "is_coupon")
    val isCoupon: Boolean = false,
    @SerialName( "created_time")
    val createdTime: Long = 0L,
    @SerialName( "isTitle")
    val isTitle: Boolean = false,
    @SerialName( "isLast")
    val isLast: Boolean = false,
) : Parcelable

@Parcelize
@Serializable
data class DeliveryListProductData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "image_thumbnail_url")
    val thumbnailUrl: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "memo")
    val memo: String = "",
    @SerialName( "qty")
    val qty: Long = 0L,
    @SerialName( "sale_price")
    val salePrice: String = "",
    @SerialName( "price")
    val price: Long = 0L,
    @SerialName( "option_add_price")
    val optionAddPrice: String = "",
    @SerialName( "option_name")
    val optionName: String = "",
    @SerialName( "is_sell")
    val isSell: Boolean = false,
    @SerialName( "is_delete")
    val isDelete: Boolean = false,
    @SerialName( "brand_id")
    val brandId: String = "",
    @SerialName( "category_id")
    val categoryIdList: List<CategoryIdData> = emptyList(),
    @SerialName( "parent_id")
    val parentId: String = "",
) : Parcelable

@Parcelize
@Serializable
data class DeliveryListDeliveryData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "invoice_no")
    val invoiceNumber: String = "",
    @SerialName( "date")
    val date: String = "",
    @SerialName( "complete_date")
    val completeDate: String = "",
    @SerialName( "state")
    val state: Int = 0,
    @SerialName( "state_name")
    val stateName: String = "",
    @SerialName( "home_delivery_code")
    val homeDeliveryCode: String = "",
    @SerialName( "home_delivery_name")
    val homeDeliveryName: String = "",
    @SerialName( "home_delivery_tracking_url")
    val homeDeliveryTrackingUrl: String = "",
) : Parcelable

@Parcelize
@Serializable
data class DeliveryListSellerData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "image_url")
    val imageUrl: String = "",
    @SerialName( "telephone")
    val telephone: String = "",
    @SerialName( "kakao_talk_id")
    val kakaoTalkId: String = "",
    @SerialName( "kakao_yellow_id")
    val kakaoYellowId: String = "",
    @SerialName( "section_group")
    val sectionGroup: SectionGroupData? = null,
) : Parcelable
