package kr.co.kmmmami.data.local

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import kr.co.kmmmami.domain.model.response.CartListData

/**
 * Created by jangsc@brandi.co.kr on 2021/09/09
 */
class CartSharedPreferencesImpl(context: Application) : CartSharedPreferences {
    private val cartSharedPreferences: SharedPreferences = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)

    override fun setCart(productId: String, isSelected: Boolean) {
        cartSharedPreferences.edit().putBoolean(productId, isSelected).apply()
    }

    override fun setSelectionData(cartList: CartListData) {
        val productList = cartList.sellerList.flatMap {
            it.productList
        }

        val selectSavedProductList = cartSharedPreferences.all.toMutableMap()

        productList.forEach {
            selectSavedProductList.remove(it.id)
            it.isSelect = cartSharedPreferences.getBoolean(it.id, true)
        }

        cartSharedPreferences.edit {
            selectSavedProductList.forEach { remove(it.key) }
        }
    }

    /**
     * 기존 하이버유저가 컨버팅된 소스로 업데이트시 SharedPreference 데이터유실을 방지하고자
     * 컨벤션에 맞지않지만 기존 하이버의 값과 동일하게 작성
     */
    companion object {
        const val SHARED_NAME = "MamiCart"
    }
}