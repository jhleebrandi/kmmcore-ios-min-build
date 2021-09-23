package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */
@Serializable
data class CouponDownloadResponse(
    @SerialName( "data")
    val data: CouponDownloadData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class CouponDownloadData(
    @SerialName( "coupon")
    val coupon: DownloadCouponData? = null,
)

@Serializable
data class DownloadCouponData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "type")
    val type: TypeData? = null,
    @SerialName( "target")
    val targetType: TypeData? = null,
    @SerialName( "discount_price")
    val discountPrice: String = "",
    @SerialName( "discount_rate")
    val discountRate: String = "",
    @SerialName( "end_time")
    val endTime: String = "",
)
