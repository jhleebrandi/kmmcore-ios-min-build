package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response
import kr.co.kmmmami.domain.model.ShippingAddressData

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */
@Serializable
data class OrderBodyResponse(
    @SerialName( "meta")
    override val meta: Meta? = null,
    @SerialName( "orderer")
    val orderer: OrderBodyOrdererData? = null,
    @SerialName( "shipping_address")
    val shippingAddress: ShippingAddressData? = null,
    @SerialName( "total_product_price")
    val totalProductPrice: Long = 0L,
    @SerialName( "total_delivery_price")
    val totalDeliveryPrice: Long = 0L,
    @SerialName( "discount_point")
    val discountPoint: Long = 0L,
    @SerialName( "settlement_price")
    val settlementPrice: Long = 0L,
    @SerialName( "discount_coupon_price")
    val discountCouponPrice: Long = 0L,
    @SerialName( "products")
    val productList: List<OrderBodyProductData> = emptyList(),
    @SerialName( "device_type")
    val deviceType: String = "",
) : Response()

@Serializable
data class OrderBodyOrdererData(
    @SerialName( "name")
    val name: String = "",
    @SerialName( "telephone")
    val telephone: String = "",
    @SerialName( "email")
    val email: String = "",
)

@Serializable
data class OrderBodyProductData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "qty")
    val qty: Long = 0L,
    @SerialName( "editor_id")
    val editorId: String = "",
    @SerialName( "coupon_id")
    val couponId: String = "",
    @SerialName( "option_add_price")
    val optionAddPrice: Long = 0L
)
