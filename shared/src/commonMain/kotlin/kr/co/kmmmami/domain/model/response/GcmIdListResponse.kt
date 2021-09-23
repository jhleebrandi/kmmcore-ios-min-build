package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */
@Serializable
data class GcmIdListResponse(
    @SerialName( "data")
    val dataList: List<GcmIdData>? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class GcmIdData(
    @SerialName( "device_code")
    val deviceCode: String = "",
)
