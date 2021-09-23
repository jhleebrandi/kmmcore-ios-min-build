package kr.co.kmmmami.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonObject
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.core_data.base.safeApiCallFlow
import kr.co.kmmmami.core_data.model.RootData
import kr.co.kmmmami.data.networking.api.MyDeliveryApi
import kr.co.kmmmami.data.utils.QueryMapKey.LT
import kr.co.kmmmami.data.utils.QueryMapUtils.getPagingQueryMap
import kr.co.kmmmami.domain.model.response.*
import kr.co.kmmmami.domain.repository.DeliveryRepository

class DeliveryRepositoryImpl(private val myDeliveryApi: MyDeliveryApi) : DeliveryRepository {

    override suspend fun getDeliveryList(
        token: String,
        lastItemId: String,
    ): Flow<ResultData<DeliveryListResponse>> {
        return flow {
            val queryMap = getPagingQueryMap()
            if (lastItemId.isNotEmpty()) queryMap[LT] = lastItemId

            emit(
                safeApiCallFlow {
                    myDeliveryApi.getDeliveryList(token, queryMap)
                }
            )
        }
    }

    override suspend fun getOrderDetail(
        token: String,
        orderId: String,
    ): Flow<ResultData<DeliveryDetailResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    myDeliveryApi.getOrderDetail(token, orderId)
                }
            )
        }
    }

    override suspend fun getOrdersDetailByOrderDetailIdCancel(
        token: String,
        orderId: String,
    ): Flow<ResultData<OrderRequestCancelResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    myDeliveryApi.getOrdersDetailByOrderDetailIdCancel(token, orderId)
                }
            )
        }
    }

    override suspend fun getOrdersDetailByOrderDetailIdRefund(
        token: String,
        orderId: String,
    ): Flow<ResultData<OrderRequestRefundResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    myDeliveryApi.getOrdersDetailByOrderDetailIdRefund(token, orderId)
                }
            )
        }
    }

    override suspend fun postOrdersDetailByOrderDetailIdCancel(
        token: String,
        orderId: String,
        bankId: String?,
        accountNumber: String,
        accountHolder: String,
    ): Flow<ResultData<OrderCancelResponse>> {
        val base = buildJsonObject {
            if (bankId != null) {
                putJsonObject("bank") {
                    put("id", bankId)
                    put("account_number", accountNumber)
                    put("accounter", accountHolder)
                }
            }
        }

        return flow {
            emit(
                safeApiCallFlow {
                    myDeliveryApi.postOrdersDetailByOrderDetailIdCancel(token, orderId, base)
                }
            )
        }
    }

    override suspend fun postOrdersDetailByOrderDetailIdRefund(
        token: String,
        data: PostRefundData
    ): Flow<ResultData<OrderRefundResponse>> {
        val base = buildJsonObject {
            putJsonObject("reason") {
                put("id", data.reason.first)
                put("text", data.reasonDetailText)
            }
            putJsonObject("bank") {
                put("id", data.bankId)
                put("account_number", data.accountNumber)
                put("accounter", data.accountHolder)
            }
        }

        return flow {
            emit(
                safeApiCallFlow {
                    myDeliveryApi.postOrdersDetailByOrderDetailIdRefund(token, data.orderId, base)
                }
            )
        }
    }

    override suspend fun orderCancelWithdrawal(
        token: String,
        orderId: String,
    ): Flow<ResultData<RootData>> {
        return flow {
            emit(
                safeApiCallFlow {
                    myDeliveryApi.deleteOrderCancel(token, orderId)
                }
            )
        }
    }

    override suspend fun orderRefundWithdrawal(
        token: String,
        orderId: String,
    ): Flow<ResultData<RootData>> {
        return flow {
            emit(
                safeApiCallFlow {
                    myDeliveryApi.deleteOrderRefund(token, orderId)
                }
            )
        }
    }

    override suspend fun purchaseConfirm(
        token: String,
        orderId: String,
    ): Flow<ResultData<RootData>> {
        return flow {
            emit(
                safeApiCallFlow {
                    myDeliveryApi.postOrderConfirm(token, orderId)
                }
            )
        }
    }

    override suspend fun ordersCancel(token: String, orderId: String): Flow<ResultData<RootData>> {
        return flow {
            emit(
                safeApiCallFlow {
                    myDeliveryApi.putOrdersCancel(token, orderId)
                }
            )
        }
    }
}
