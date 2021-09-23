package kr.co.kmmmami.domain.model.response

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response
import kr.co.kmmmami.domain.model.ShippingAddressData

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */
@Serializable
data class OrderTemporaryResponse(
    @SerialName( "data")
    val data: OrderTemporaryData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class OrderTemporaryData(
    @SerialName( "point")
    var point: Long = 0L,
    @SerialName( "info")
    val info: OrderTemporaryInfoData? = null,
    @SerialName( "orderer")
    val orderer: OrderTemporaryOrdererData? = null,
    @SerialName( "coupons")
    val couponList: List<CouponData> = emptyList(),
    @SerialName( "sellers")
    val sellerList: List<CartListSellerData> = emptyList(),
    @SerialName( "total")
    val total: CartListTotalData? = null,
    @SerialName( "shipping_address")
    var shippingAddress: ShippingAddressData? = null,
    @SerialName( "settlement_type")
    val settlementType: List<SettlementTypeData> = emptyList(),
)

@Serializable
data class OrderTemporaryInfoData(
    @SerialName( "max_point_ratio")
    val maximumPointRatio: Int = 0,
    @SerialName( "min_settlement_price")
    val minimumSettlementPrice: Long = 0L,
    @SerialName( "notice")
    val notice: NoticeData? = null,
    @SerialName( "delivery_requests")
    val deliveryRequests: List<DeliveryRequestsData>? = null,
)

@Serializable
data class OrderTemporaryOrdererData(
    @SerialName( "is_certification")
    val isCertification: Boolean = false,
    @SerialName( "name")
    val name: String = "",
    @SerialName( "telephone")
    val telephone: String = "",
    @SerialName( "email")
    val email: String = "",
)

@Serializable
data class SettlementTypeData(
    @SerialName( "id")
    val id: Int = 0,
    @SerialName( "String")
    val string: String = "",
)

@Serializable
data class NoticeData(
    @SerialName( "settlement")
    val settlement: NoticeSettlementData? = null,
)

@Serializable
data class NoticeSettlementData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "text")
    val text: String = "",
)

@Parcelize
@Serializable
data class DeliveryRequestsData(
    @SerialName( "id")
    var id: String = "",
    @SerialName( "name")
    var name: String = "",
) : Parcelable
