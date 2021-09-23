package kr.co.kmmmami.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.core_data.model.RootData
import kr.co.kmmmami.domain.model.request.CartRequest
import kr.co.kmmmami.domain.model.response.CartCountResponse
import kr.co.kmmmami.domain.model.response.CartListData
import kr.co.kmmmami.domain.model.response.CartListResponse
import kr.co.kmmmami.domain.model.response.PointResponse

interface OrderRepository {
    suspend fun getPoint(
        token: String,
    ): Flow<ResultData<PointResponse>>

    suspend fun postCarts(
        token: String,
        request: CartRequest,
    ): Flow<ResultData<CartCountResponse>>

    suspend fun putCartCount(productId: String, count: Long): Flow<ResultData<RootData>>

    suspend fun getCartList(): Flow<ResultData<CartListResponse>>

    suspend fun deleteCart(productIds: String, isDeleteAll: Boolean, isSoldOutDelete: Boolean): Flow<ResultData<CartCountResponse>>

    fun setCart(productId: String, isSelect: Boolean)

    fun setSelect(productId: String, isSelect: Boolean)

    fun setSelectionData(cartList: CartListData)
}
