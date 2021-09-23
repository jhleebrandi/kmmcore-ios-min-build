package kr.co.kmmmami.domain.model.request

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class OrderBodyRequest(
    @SerialName("orderer")
    var orderer: OrderBodyOrdererData? = null,
    @SerialName("shipping_address")
    var shippingAddress: OrderShippingAddressData? = null,
    @SerialName("total_product_price")
    var totalProductPrice: Long = 0L,
    @SerialName("total_delivery_price")
    var totalDeliveryPrice: Long = 0L,
    @SerialName("discount_point")
    var discountPoint: Long = 0L,
    @SerialName("settlement_price")
    var settlementPrice: Long = 0L,
    @SerialName("discount_coupon_price")
    var discountCouponPrice: Long = 0L,
    @SerialName("products")
    var productList: List<OrderBodyProductData> = emptyList(),
    @SerialName("device_type")
    var deviceType: String = "",
) : Parcelable

@Parcelize
@Serializable
data class OrderBodyOrdererData(
    @SerialName("name")
    var name: String = "",
    @SerialName("telephone")
    var telephone: String = "",
    @SerialName("email")
    var email: String = "",
) : Parcelable

@Parcelize
@Serializable
data class OrderBodyProductData(
    @SerialName("id")
    var id: String = "",
    @SerialName("qty")
    var qty: Long = 0L,
    @SerialName("option_add_price")
    var optionAddPrice: Long = 0L,
    @SerialName("editor_id")
    var editorId: String? = null,
    @SerialName("coupon_id")
    var couponId: String? = null,
) : Parcelable

@Parcelize
@Serializable
data class OrderShippingAddressData(
    @SerialName("name")
    var name: String = "",
    @SerialName("telephone")
    var telephone: String = "",
    @SerialName("zipcode")
    var zipCode: String = "",
    @SerialName("address1")
    var address: String = "",
    @SerialName("address2")
    var remainingAddress: String = "",
    @SerialName("delivery_memo")
    var deliveryMemo: String = "",
    @SerialName("delivery_request_id")
    var currentDeliveryRequestId: String? = null,
) : Parcelable
