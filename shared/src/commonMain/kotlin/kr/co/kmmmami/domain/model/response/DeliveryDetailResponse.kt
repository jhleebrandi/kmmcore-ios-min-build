package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response
import kr.co.kmmmami.domain.model.SettlementData
import kr.co.kmmmami.domain.model.ShippingAddressData

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */
@Serializable
data class DeliveryDetailResponse(
    @SerialName( "data")
    val data: DeliveryDetailData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class DeliveryDetailData(
    @SerialName( "id")
    var id: String = "",
    @SerialName( "code")
    var code: String = "",
    @SerialName( "total_product_price")
    var totalProductPrice: Long = 0L,
    @SerialName( "total_delivery_price")
    var totalDeliveryPrice: Long = 0L,
    @SerialName( "discount_point")
    var discountPoint: Long = 0L,
    @SerialName( "settlement_price")
    var settlementPrice: Long = 0L,
    @SerialName( "saving_point")
    var savingPoint: Long = 0L,
    @SerialName( "discount_coupon_price")
    var discountCouponPrice: Long = 0L,
    @SerialName( "settlement")
    var settlement: SettlementData? = null,
    @SerialName( "orderer")
    var orderer: DeliveryDetailOrdererData? = null,
    @SerialName( "shipping_address")
    var shippingAddress: ShippingAddressData? = null,
    @SerialName( "created_time")
    var createdTime: Long = 0L,
    @SerialName( "order_details")
    var orderDetailList: List<DeliveryDetailOrderDetailData> = emptyList(),
)

@Serializable
data class DeliveryDetailOrdererData(
    @SerialName( "name")
    val name: String = "",
    @SerialName( "telephone")
    val telephone: String = "",
    @SerialName( "email")
    val email: String = "",
)

@Serializable
data class DeliveryDetailOrderDetailData(
    @SerialName( "id")
    var id: String = "",
    @SerialName( "code")
    var code: String = "",
    @SerialName( "product")
    var product: DeliveryDetailProductData? = null,
    @SerialName( "delivery")
    var delivery: DeliveryDetailDeliveryData? = null,
    @SerialName( "state")
    var state: String = "",
    @SerialName( "state_name")
    var stateName: String = "",
    @SerialName( "created_time")
    var createdTime: String = "",
    @SerialName( "add_info")
    val addInfoList: List<SectionData> = emptyList(),
    @SerialName( "seller")
    val seller: DeliveryListSellerData? = null,
)

@Serializable
data class DeliveryDetailProductData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "image_thumbnail_url")
    val thumbnailUrl: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "qty")
    val qty: Long = 0L,
    @SerialName( "sale_price")
    val salePrice: Long = 0L,
    @SerialName( "option_name")
    val optionName: String = "",
    @SerialName( "is_sell")
    val isSell: Boolean = false,
    @SerialName( "is_delete")
    val isDelete: Boolean = false,
)

@Serializable
data class DeliveryDetailDeliveryData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "date")
    val date: String = "",
    @SerialName( "state")
    val state: String = "",
)
