package kr.co.kmmmami.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.co.kmmmami.core_data.base.safeApiCallFlow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.data.networking.api.HomeRankApi
import kr.co.kmmmami.data.utils.QueryMapKey.ORDER
import kr.co.kmmmami.data.utils.QueryMapKey.STORE_TYPE
import kr.co.kmmmami.data.utils.QueryMapKey.TYPE
import kr.co.kmmmami.data.utils.QueryMapKey.VERSION
import kr.co.kmmmami.data.utils.QueryMapUtils.getPagingQueryMap
import kr.co.kmmmami.domain.model.response.ProductListResponse
import kr.co.kmmmami.domain.repository.RankRepository

class RankRepositoryImpl(private val homeRankApi: HomeRankApi) : RankRepository {

    override suspend fun getRank(
        token: String,
        storeType: String,
        orderFilter: String
    ): Flow<ResultData<ProductListResponse>> {
        return flow {
            val queryMap = getPagingQueryMap(limit = 0).apply {
                this[STORE_TYPE] = storeType
                this[TYPE] = "best"
                this[VERSION] = "204"
                this[ORDER] = orderFilter
            }

            emit(
                safeApiCallFlow { homeRankApi.getRank(token, queryMap) }
            )
        }
    }

    override suspend fun getCategoryData(
        token: String,
        categoryId: Int,
        storeType: String,
        orderFilter: String
    ): Flow<ResultData<ProductListResponse>> {
        return flow {
            val queryMap = getPagingQueryMap(limit = 0).apply {
                this[STORE_TYPE] = storeType
                this[TYPE] = "best"
                this[VERSION] = "204"
                this[ORDER] = orderFilter
            }

            emit(
                safeApiCallFlow { homeRankApi.getBestCategory(token, categoryId, queryMap) }
            )
        }
    }
}
