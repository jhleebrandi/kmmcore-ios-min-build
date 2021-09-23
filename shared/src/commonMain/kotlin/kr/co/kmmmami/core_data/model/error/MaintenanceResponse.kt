package kr.co.kmmmami.core_data.model.error

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by jangsc@brandi.co.kr on 2021/08/10
 */
@Serializable
data class MaintenanceResponse(
    @SerialName("data")
    val data: MaintenanceData? = null,
    @SerialName("meta")
    override val meta: Meta? = null,
) : Response()

@Parcelize
@Serializable
data class MaintenanceData(
    @SerialName("start_time")
    val startTime: Long = 0,
    @SerialName("end_time")
    val endTime: Long = 0,
) : Parcelable