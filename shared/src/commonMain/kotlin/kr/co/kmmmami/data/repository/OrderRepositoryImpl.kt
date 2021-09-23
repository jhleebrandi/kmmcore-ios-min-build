package kr.co.kmmmami.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.co.kmmmami.core_data.base.safeApiCallFlow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.core_data.model.RootData
import kr.co.kmmmami.data.local.CartSharedPreferences
import kr.co.kmmmami.data.local.MamiSessionSharedPreferences
import kr.co.kmmmami.data.networking.api.CartApi
import kr.co.kmmmami.data.networking.api.OrderApi
import kr.co.kmmmami.data.utils.QueryMapKey.PRODUCT_ID
import kr.co.kmmmami.data.utils.QueryMapKey.TYPE
import kr.co.kmmmami.data.utils.QueryMapKey.VERSION
import kr.co.kmmmami.domain.model.request.CartRequest
import kr.co.kmmmami.domain.model.response.CartCountResponse
import kr.co.kmmmami.domain.model.response.CartListData
import kr.co.kmmmami.domain.model.response.CartListResponse
import kr.co.kmmmami.domain.model.response.PointResponse
import kr.co.kmmmami.domain.repository.OrderRepository

class OrderRepositoryImpl(
    private val mamiSessionSharedPreferences: MamiSessionSharedPreferences,
    private val orderApi: OrderApi,
    private val cartApi: CartApi,
    private val cartSharedPreferences: CartSharedPreferences
) : OrderRepository {
    override suspend fun getPoint(token: String): Flow<ResultData<PointResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    orderApi.getPoint(token)
                }
            )
        }
    }

    override suspend fun postCarts(
        token: String,
        request: CartRequest
    ): Flow<ResultData<CartCountResponse>> {
        return flow {
            val queryMap = HashMap<String, String>().apply {
                put(VERSION, "204")
                put(TYPE, "new")
            }

            emit(
                safeApiCallFlow {
                    cartApi.postCarts(token, queryMap, request)
                }
            )
        }
    }

    override suspend fun getCartList(): Flow<ResultData<CartListResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    cartApi.getCartList(mamiSessionSharedPreferences.accessToken)
                }
            )
        }
    }

    override suspend fun deleteCart(
        productIds: String,
        isDeleteAll: Boolean,
        isSoldOutDelete: Boolean
    ): Flow<ResultData<CartCountResponse>> {
        return flow {
            val queryMap = HashMap<String, String>().apply {
                if (productIds.isNotEmpty()) {
                    put(PRODUCT_ID, productIds)
                }

                if (isDeleteAll) {
                    put(TYPE, "all")
                }

                if (isSoldOutDelete) {
                    put(TYPE, "sold-out")
                }
            }

            emit(
                safeApiCallFlow {
                    cartApi.deleteCart(mamiSessionSharedPreferences.accessToken, queryMap)
                }
            )
        }
    }

    override suspend fun putCartCount(productId: String, count: Long): Flow<ResultData<RootData>> {
        return flow {
            val queryMap = HashMap<String, String>().apply {
                put(VERSION, "204")
            }

            emit(
                safeApiCallFlow {
                    cartApi.putCartCount(
                        mamiSessionSharedPreferences.accessToken,
                        productId,
                        count,
                        queryMap
                    )
                }
            )
        }
    }

    override fun setCart(productId: String, isSelect: Boolean) {
        cartSharedPreferences.setCart(productId, isSelect)
    }

    override fun setSelect(productId: String, isSelect: Boolean) {
        cartSharedPreferences.setCart(productId, isSelect)
    }

    override fun setSelectionData(cartList: CartListData) {
        cartSharedPreferences.setSelectionData(cartList)
    }
}
