package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/16
 */
@Serializable
data class PointDownloadResponse(
    @SerialName( "data")
    val data: PointDownloadData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class PointDownloadData(
    @SerialName( "point")
    var point: DownloadPointData? = null,
)

@Serializable
data class DownloadPointData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "price")
    val price: String = "",
    @SerialName( "end_time")
    val endTime: String? = null,
)
