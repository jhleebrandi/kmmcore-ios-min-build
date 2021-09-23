package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

@Serializable
data class CouponWithBenefitsMyListResponse(
    @SerialName( "data")
    val data: CouponWithBenefitsMyListData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class CouponWithBenefitsMyListData(
    @SerialName( "benefits_coupons")
    val benefitsCoupons: List<CouponData>? = null,
    @SerialName( "coupons")
    val couponList: List<CouponData>? = null,
)
