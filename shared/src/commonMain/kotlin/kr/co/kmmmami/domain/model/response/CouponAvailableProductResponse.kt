package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

@Serializable
data class CouponAvailableProductResponse(
    @SerialName( "data")
    val data: CouponAvailableProductData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class CouponAvailableProductData(
    @SerialName( "coupons")
    val coupons: CouponData,
    @SerialName( "products")
    val products: List<ProductData>? = null,
)
