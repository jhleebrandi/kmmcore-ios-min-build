package kr.co.kmmmami.domain.model

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */
@Parcelize
@Serializable
data class ShippingAddressData(
    @SerialName("id")
    val id: String = "",
    @SerialName("name")
    val name: String = "",
    @SerialName("telephone")
    val telephone: String = "",
    @SerialName("zipcode")
    val zipCode: String = "",
    @SerialName("address1")
    val address: String = "",
    @SerialName("address2")
    val remainingAddress: String = "",
    @SerialName("delivery_memo")
    var deliveryMemo: String = "",
    @SerialName("current_delivery_request_id")
    var currentDeliveryRequestId: String? = null,
) : Parcelable {
    @Transient
    var isWarningData: Boolean = false
    fun setWarning(isWarning: Boolean) {
        this.isWarningData = isWarning
    }

    fun isWarning(): Boolean {
        return isWarningData
    }
}
