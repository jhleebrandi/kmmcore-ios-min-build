package kr.co.kmmmami.domain.model.response

import dev.icerock.moko.parcelize.Parcelize
import dev.icerock.moko.parcelize.Parcelable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

@Serializable
data class DeliveryAddressListResponse(
    @SerialName( "data")
    val dataList: List<DeliveryAddressData>? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class DeliveryAddressResponse(
    @SerialName( "data")
    val data: DeliveryAddressData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Parcelize
@Serializable
data class DeliveryAddressData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    var name: String = "",
    @SerialName( "telephone")
    var telephone: String = "",
    @SerialName( "zipcode")
    var zipCode: String = "",
    @SerialName( "address1")
    var address: String = "",
    @SerialName( "address2")
    var remainingAddress: String = "",
    @SerialName( "delivery_memo")
    var deliveryMemo: String = "",
    @SerialName( "is_default")
    var isDefault: Boolean = false,
) : Parcelable
