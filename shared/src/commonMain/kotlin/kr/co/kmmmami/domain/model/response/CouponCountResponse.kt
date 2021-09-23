package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

@Serializable
data class CouponCountResponse(
    @SerialName( "data")
    val data: CouponCountData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class CouponCountData(
    @SerialName( "count")
    val count: Int = 0,
    @SerialName( "available_count")
    val availableCount: Int = 0,
    @SerialName( "expiration_count")
    val expirationCount: Int = 0,
)
