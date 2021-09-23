package kr.co.kmmmami.core_data.model

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Parcelize
@Serializable
data class Meta(
    @SerialName("code")
    val code: Int = 0,
    @SerialName("message")
    val message: String = "",
    @SerialName("count")
    var count: Int = 0,
    @SerialName("error_code")
    val errorCode: Int = 0,
    @SerialName("error_message")
    val errorMessage: String = "",
    @SerialName("brandi_token")
    val brandiToken: String = "",
    @SerialName("join_type")
    val joinType: String = "",
    @SerialName("alert")
    val alert: Alert? = null,
    @SerialName("image_popup")
    val imagePopup: ImagePopup? = null,
    @SerialName("error_data")
    var errorData: ErrorData? = null,
    @SerialName("is_sponsored")
    var isSponsored: Boolean = false,
) : Parcelable {
    fun getErrorCodeData(): Int {
        return if (errorCode == 0) code else errorCode
    }
}

@Parcelize
@Serializable
data class Alert(
    @SerialName("subject")
    val subject: String = "",
    @SerialName("message")
    val message: String = ""
) : Parcelable

@Parcelize
@Serializable
data class ImagePopup(
    @SerialName("id")
    val id: String = "",
    @SerialName("image_url")
    val imageUrl: String = "",
    @SerialName("repeat_cycle_minutes")
    val repeatCycleMinutes: Int = 0
) : Parcelable

@Parcelize
@Serializable
data class ErrorData(
    @SerialName("code")
    val code: Int = 0,
    @SerialName("state")
    val state: String = "",
    @SerialName("message")
    var message: String = "",
    @SerialName("alert_message")
    val alertMessage: String = "",
    /**
     * Brnadi에는 없는 Model들
     */
    @SerialName("available")
    val available: Boolean = false,
    @SerialName("available_date")
    val availableDate: String = "",
    @SerialName("start_date")
    val startDate: Int = 0,
    @SerialName("end_date")
    val endDate: Int = 0
) : Parcelable {
    @Transient
    var data: Any? = null

    @Transient
    var reqData: Any? = null
}
