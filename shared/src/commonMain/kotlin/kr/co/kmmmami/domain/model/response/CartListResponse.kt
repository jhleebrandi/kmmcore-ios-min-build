package kr.co.kmmmami.domain.model.response

import dev.icerock.moko.parcelize.Parcelable
import dev.icerock.moko.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by parkkks2@brandi.co.kr on 2020/12/15
 */

@Serializable
data class CartListResponse(
    @SerialName( "data")
    val data: CartListData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class CartListData(
    @SerialName( "middle_banners")
    val middleBannerList: List<BannerListData>? = null,
    @SerialName( "total")
    val total: CartListTotalData? = null,
    @SerialName( "sellers")
    val sellerList: List<CartListSellerData> = emptyList(),
)

@Serializable
data class CartListTotalData(
    @SerialName( "product_price")
    val productPrice: Long = 0L,
    @SerialName( "delivery_price")
    val deliveryPrice: Long = 0L,
    @SerialName( "price")
    val price: Long = 0L
)

@Parcelize
@Serializable
data class CartListSellerData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "delivery_price")
    val deliveryPrice: Long = 0L,
    @SerialName( "free_delivery_price")
    val freeDeliveryPrice: Long = 0L,
    @SerialName( "type")
    val type: SellerTypeData? = null,
    @SerialName( "products")
    var productList: List<CartListSellerProductData> = emptyList(),
) : Parcelable {
    fun isContainSelect(): Boolean {
        var isSelect = false

        productList.forEach {
            isSelect = isSelect || !it.isSelect
        }

        return isSelect
    }

    fun getTotalPrice(): Long {
        var totalPrice = 0L

        productList.forEach {
            if (!it.isSelect) {
                val itemPrice = (it.salePrice).toLong() + (it.optionAddPrice).toLong() * it.cartQty
                totalPrice += itemPrice
            }
        }

        return totalPrice
    }

    fun isAllEssential(parentId: String): Boolean {
        var isEssential = true

        productList.forEach { productData ->
            if (productData.parentId.equals(parentId, ignoreCase = true) && !productData.isEssential
            ) {
                isEssential = productData.isEssential
            }
        }
        return isEssential
    }

    fun getSelectList(parentId: String): List<CartListSellerProductData> {
        return productList.filter { productData ->
            productData.parentId.equals(parentId, ignoreCase = true) && productData.isSelect
        }
    }

    fun getProductListSameParent(parentId: String): List<CartListSellerProductData> {
        return productList.filter { productData ->
            productData.parentId.equals(parentId, ignoreCase = true)
        }
    }
}

@Parcelize
@Serializable
data class CartListSellerProductData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "parent_id")
    val parentId: String = "",
    @SerialName( "image_thumbnail_url")
    val thumbnailUrl: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "memo")
    val memo: String = "",
    @SerialName( "cart_qty")
    var cartQty: Long = 0L,
    @SerialName( "qty")
    val qty: Long = 0L,
    @SerialName( "min_order_qty")
    val minimumOrderQty: Long = 0L,
    @SerialName( "max_order_qty")
    val maximumOrderQty: Long = 0L,
    @SerialName( "price")
    val price: String = "",
    @SerialName( "sale_price")
    val salePrice: String = "",
    @SerialName( "sale_percent")
    val salePercent: Int = 0,
    @SerialName( "option_name")
    val optionName: String = "",
    @SerialName( "is_sell")
    val isSell: Boolean = false,
    @SerialName( "is_delete")
    val isDelete: Boolean = false,
    @SerialName( "editor_id")
    val editorId: String? = null,
    @SerialName( "option_add_price")
    val optionAddPrice: String = "",
    @SerialName( "is_essential")
    val isEssential: Boolean = false,
    @SerialName( "coupons")
    val couponList: List<CouponData> = emptyList(),
    @SerialName( "selectedCoupon")
    var selectedCoupon: CouponData? = null,
    @SerialName( "category_hierarchies")
    val categoryHierarchyList: List<CategoryHierarchyData> = emptyList(),
    var isSelect: Boolean = false,
) : Parcelable {
    // 담은 수량 < 최소 구매 수량
    fun isMinWarning(): Boolean = cartQty < minimumOrderQty

    // 담은 수량 > 최대 구매 수량 || 담은 수량 > 재고 수량
    fun isMaxWarning(): Boolean = cartQty > maximumOrderQty || cartQty > qty

    // 재고도 같이 판단한다.
    fun isSellState(): Boolean {
        return if (qty < minimumOrderQty) {
            false
        } else {
            isSell
        }
    }

    fun isSelling(): Boolean {
        return if (qty < minimumOrderQty) {
            false
        } else {
            isSell
        }
    }

    fun isSoldOut(): Boolean {
        return !isSelling() || isDelete
    }
}

@Parcelize
@Serializable
data class CategoryHierarchyData(
    @SerialName( "id")
    val id: String = "",
    @SerialName( "name")
    val name: String = "",
    @SerialName( "depth")
    val depth: Int = 0,
) : Parcelable
