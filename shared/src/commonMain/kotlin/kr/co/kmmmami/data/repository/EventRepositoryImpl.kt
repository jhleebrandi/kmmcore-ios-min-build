package kr.co.kmmmami.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.co.kmmmami.core_data.base.safeApiCallFlow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.data.networking.api.HomeEventApi
import kr.co.kmmmami.data.utils.QueryMapKey.IS_FIRST
import kr.co.kmmmami.data.utils.QueryMapKey.IS_PROGRESS
import kr.co.kmmmami.data.utils.QueryMapKey.NEW_FILTER
import kr.co.kmmmami.data.utils.QueryMapKey.VERSION
import kr.co.kmmmami.data.utils.QueryMapUtils.getPagingQueryMap
import kr.co.kmmmami.domain.model.response.EventBodyResponse
import kr.co.kmmmami.domain.model.response.EventListResponse
import kr.co.kmmmami.domain.model.response.EventListWithTotalCountResponse
import kr.co.kmmmami.domain.model.response.ProductListResponse
import kr.co.kmmmami.domain.repository.EventRepository

class EventRepositoryImpl(private val eventApi: HomeEventApi) : EventRepository {
    override suspend fun getEventWithTotalCount(
        token: String,
        offset: Int,
        isProgress: Boolean
    ): Flow<ResultData<EventListWithTotalCountResponse>> {
        return flow {
            val map = getPagingQueryMap(offset = offset).apply {
                this[IS_FIRST] = (offset == 0).toString()
                this[IS_PROGRESS] = isProgress.toString()
                this[VERSION] = "204"
            }

            emit(
                safeApiCallFlow {
                    eventApi.getEvent(
                        token,
                        map
                    )
                }
            )
        }
    }

    override suspend fun getEvent(
        token: String,
        offset: Int,
        isProgress: Boolean
    ): Flow<ResultData<EventListResponse>> {
        return flow {
            val map = getPagingQueryMap(offset = offset).apply {
                this[NEW_FILTER] = "true"
                this[IS_PROGRESS] = isProgress.toString()
                this[VERSION] = "204"
            }

            emit(
                safeApiCallFlow {
                    eventApi.getEvent(
                        token,
                        map
                    )
                }
            )
        }
    }

    override suspend fun getEventsById(
        token: String,
        eventId: String
    ): Flow<ResultData<EventBodyResponse>> {
        return flow {
            val queryMap = HashMap<String, String>().apply {
                this[VERSION] = "2101"
            }

            emit(
                safeApiCallFlow {
                    eventApi.getEventById(
                        token,
                        eventId,
                        queryMap
                    )
                }
            )
        }
    }

    override suspend fun getEventsProductsById(
        token: String,
        eventId: String,
        offset: Int,
        limit: Int
    ): Flow<ResultData<ProductListResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    eventApi.getEventProductsById(
                        token,
                        eventId,
                        getPagingQueryMap(offset = offset, limit = limit)
                    )
                }
            )
        }
    }
}
