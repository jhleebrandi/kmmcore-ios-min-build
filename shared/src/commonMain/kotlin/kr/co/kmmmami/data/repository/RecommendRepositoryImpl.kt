package kr.co.kmmmami.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.co.kmmmami.core_data.base.safeApiCallFlow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.data.networking.api.LoginAPI
import kr.co.kmmmami.data.networking.api.RecommendAPI
import kr.co.kmmmami.data.utils.QueryMapKey
import kr.co.kmmmami.data.utils.QueryMapUtils.getPagingQueryMap
import kr.co.kmmmami.data.utils.QueryMapUtils.getQueryMapOnlyLimit
import kr.co.kmmmami.domain.model.request.SearchProductRequest
import kr.co.kmmmami.domain.model.response.PopularSearchListResponse
import kr.co.kmmmami.domain.model.response.ProductListResponse
import kr.co.kmmmami.domain.model.response.RecommendResponse
import kr.co.kmmmami.domain.repository.RecommendRepository

class RecommendRepositoryImpl(
    private val loginApi: LoginAPI,
    private val recommendApi: RecommendAPI,
) : RecommendRepository {

    override suspend fun getUserSelfRecommend(
        token: String,
        limit: Int
    ): Flow<ResultData<ProductListResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    recommendApi.getUserSelfRecommend(token, getPagingQueryMap(limit = limit))
                }
            )
        }
    }

    override suspend fun getGuestUsersSelfRecommendForAi(
        token: String,
        sid: String
    ): Flow<ResultData<ProductListResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    recommendApi.getGuestUserSelfRecommend(token, sid, getPagingQueryMap(limit = 500))
                }
            )
        }
    }

    override suspend fun getUserSelfRecommendCode(
        token: String
    ): Flow<ResultData<RecommendResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    loginApi.getUserSelfRecommendCode(token)
                }
            )
        }
    }

    override suspend fun getRelativeProducts(
        token: String,
        productId: String
    ): Flow<ResultData<ProductListResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    recommendApi.getRelativeProducts(token, productId)
                }
            )
        }
    }

    override suspend fun getRecommendProducts(
        token: String,
        productId: String
    ): Flow<ResultData<ProductListResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    recommendApi.getRecommendProducts(token, productId, getQueryMapOnlyLimit(limit = 10))
                }
            )
        }
    }

    override suspend fun getPopularSearches(token: String): Flow<ResultData<PopularSearchListResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    recommendApi.getPopularSearches(token)
                }
            )
        }
    }

    override suspend fun getSearchSimilarProducts(
        token: String,
        sid: String,
        productId: String
    ): Flow<ResultData<ProductListResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    recommendApi.getSearchSimilarProducts(token, sid, productId, getPagingQueryMap(limit = 10))
                }
            )
        }
    }

    override suspend fun getGuestUsersSelfRecommend(
        token: String,
        sid: String,
        requestData: SearchProductRequest
    ): Flow<ResultData<ProductListResponse>> {
        return flow {
            val queryMap = HashMap<String, String>().apply {
                put(QueryMapKey.TOTAL_COUNT, "true")
                with(requestData) {
                    offset?.let {
                        put(QueryMapKey.OFFSET, it.toString())
                    }

                    put(QueryMapKey.LIMIT, limit.toString())

                    orderFilter?.let {
                        put(QueryMapKey.ORDER, it)
                    }
                    storeRootCategoryId?.let {
                        put(QueryMapKey.STORE_ROOT_CATEGORY_ID, it)
                    }
                    ranking?.let {
                        put(QueryMapKey.RANKING, it)
                    }
                }
            }

            emit(
                safeApiCallFlow {
                    recommendApi.getGuestUserSelfRecommend(token, sid, queryMap)
                }
            )
        }
    }
}
