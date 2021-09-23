package kr.co.kmmmami.domain.model.response

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

@Serializable
data class OrderRefundResponse(
    @SerialName( "data")
    val data: OrderRefundData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Parcelize
@Serializable
data class OrderRefundData(
    @SerialName( "add_info")
    val addInfo: RefundAddInfoData? = null,
    @SerialName( "refund")
    val refund: RefundResponseData? = null,
    @SerialName( "section_1")
    val sectionList: List<SectionData> = emptyList(),
) : Parcelable

@Parcelize
@Serializable
data class RefundAddInfoData(
    @SerialName( "order")
    val order: RefundOrderData? = null,
    @SerialName( "payment_complete_date")
    val paymentCompleteDate: String = "",
    @SerialName( "product")
    val product: RefundProductData? = null,
    @SerialName( "seller")
    val seller: RefundSellerData? = null,
) : Parcelable

@Parcelize
@Serializable
data class RefundOrderData(
    @SerialName( "code")
    val code: String = "",
    @SerialName( "detail_qty")
    val detailQty: Long = 0L,
    @SerialName( "detail_sale_price")
    val detailSalePrice: Long = 0L,
    @SerialName( "id")
    val id: String = "",
) : Parcelable

@Parcelize
@Serializable
data class RefundProductData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
) : Parcelable

@Parcelize
@Serializable
data class RefundSellerData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
) : Parcelable

@Parcelize
@Serializable
data class RefundResponseData(
    @SerialName( "type")
    val type: Int = 0,
    @SerialName( "message")
    val message: String = "",
) : Parcelable

data class PostRefundData(
    var orderId: String,
    var reason: Pair<String, String>,
    var reasonText: String,
    var reasonDetailText: String?,
    var bankId: String?,
    var accountNumber: String?,
    var accountHolder: String?,
    var orderCode: String?,
    var productId: String?,
    var productName: String?,
)
