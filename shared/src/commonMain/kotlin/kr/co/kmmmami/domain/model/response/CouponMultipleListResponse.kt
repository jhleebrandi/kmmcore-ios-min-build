package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

@Serializable
data class CouponMultipleListResponse(
    @SerialName( "data")
    val data: SucceedCouponData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class SucceedCouponData(
    @SerialName( "succeed_coupon")
    val dataList: List<CouponData>? = null,
)
