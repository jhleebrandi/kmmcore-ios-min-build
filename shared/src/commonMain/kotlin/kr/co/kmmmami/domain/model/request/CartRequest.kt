package kr.co.kmmmami.domain.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CartRequest(
    @SerialName("carts")
    val cartItemList: List<CartItem>,
)

@Serializable
data class CartItem(
    @SerialName("product_id")
    val productId: String,
    @SerialName("qty")
    val qty: Long,
    @SerialName("name")
    val name: String,

    val trackerData: CartItemTrackerData? = null,
)

// facebook tracker에서 사용
@Serializable
data class CartItemTrackerData(
    val productParentId: String,
    val price: String,
)
