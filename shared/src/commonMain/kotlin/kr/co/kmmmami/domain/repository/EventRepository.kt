package kr.co.kmmmami.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.domain.model.response.EventBodyResponse
import kr.co.kmmmami.domain.model.response.EventListResponse
import kr.co.kmmmami.domain.model.response.EventListWithTotalCountResponse
import kr.co.kmmmami.domain.model.response.ProductListResponse

interface EventRepository {
    suspend fun getEventWithTotalCount(
        token: String,
        offset: Int,
        isProgress: Boolean
    ): Flow<ResultData<EventListWithTotalCountResponse>>

    suspend fun getEvent(
        token: String,
        offset: Int,
        isProgress: Boolean
    ): Flow<ResultData<EventListResponse>>

    suspend fun getEventsById(
        token: String,
        eventId: String
    ): Flow<ResultData<EventBodyResponse>>

    suspend fun getEventsProductsById(
        token: String,
        eventId: String,
        offset: Int,
        limit: Int
    ): Flow<ResultData<ProductListResponse>>
}
