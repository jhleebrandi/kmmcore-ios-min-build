package kr.co.kmmmami.data.local

import kr.co.kmmmami.domain.model.response.CartListData

/**
 * Created by jangsc@brandi.co.kr on 2021/09/09
 */
interface CartSharedPreferences {
    fun setCart(productId: String, isSelected: Boolean)

    fun setSelectionData(cartList: CartListData)
}