package kr.co.kmmmami.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.core_data.model.RootData
import kr.co.kmmmami.domain.model.response.*

interface DeliveryRepository {

    suspend fun getDeliveryList(
        token: String,
        lastItemId: String
    ): Flow<ResultData<DeliveryListResponse>>

    suspend fun getOrderDetail(
        token: String,
        orderId: String
    ): Flow<ResultData<DeliveryDetailResponse>>

    suspend fun getOrdersDetailByOrderDetailIdCancel(
        token: String,
        orderId: String
    ): Flow<ResultData<OrderRequestCancelResponse>>

    suspend fun getOrdersDetailByOrderDetailIdRefund(
        token: String,
        orderId: String
    ): Flow<ResultData<OrderRequestRefundResponse>>

    suspend fun postOrdersDetailByOrderDetailIdCancel(
        token: String,
        orderId: String,
        bankId: String?,
        accountNumber: String,
        accountHolder: String,
    ): Flow<ResultData<OrderCancelResponse>>

    suspend fun postOrdersDetailByOrderDetailIdRefund(
        token: String,
        data: PostRefundData
    ): Flow<ResultData<OrderRefundResponse>>

    suspend fun orderCancelWithdrawal(
        token: String,
        orderId: String
    ): Flow<ResultData<RootData>>

    suspend fun orderRefundWithdrawal(
        token: String,
        orderId: String
    ): Flow<ResultData<RootData>>

    suspend fun purchaseConfirm(
        token: String,
        orderId: String
    ): Flow<ResultData<RootData>>

    suspend fun ordersCancel(token: String, orderId: String): Flow<ResultData<RootData>>
}
