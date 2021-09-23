package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by jangsc@brandi.co.kr on 12/16/20
 */
@Serializable
data class UserMetaResponse(
    @SerialName( "data")
    val data: UserMetaData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class UserMetaData(
    @SerialName( "cart")
    val cart: CartData? = null,
    @SerialName( "coupon")
    val coupon: UserMetaCouponData? = null,
)

@Serializable
data class CartData(
    @SerialName( "count")
    val count: Int = 0,
    @SerialName( "product_ids")
    val productIdList: List<String> = emptyList(),
)

@Serializable
data class UserMetaCouponData(
    @SerialName( "count")
    val count: Int = 0,
    @SerialName( "ids")
    val idList: List<String> = emptyList(),
)
