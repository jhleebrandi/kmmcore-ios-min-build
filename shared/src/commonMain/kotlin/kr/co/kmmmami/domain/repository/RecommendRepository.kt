package kr.co.kmmmami.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.domain.model.request.SearchProductRequest
import kr.co.kmmmami.domain.model.response.PopularSearchListResponse
import kr.co.kmmmami.domain.model.response.ProductListResponse
import kr.co.kmmmami.domain.model.response.RecommendResponse

interface RecommendRepository {
    suspend fun getUserSelfRecommend(
        token: String,
        limit: Int
    ): Flow<ResultData<ProductListResponse>>

    suspend fun getGuestUsersSelfRecommendForAi(
        token: String,
        sid: String
    ): Flow<ResultData<ProductListResponse>>

    suspend fun getUserSelfRecommendCode(
        token: String
    ): Flow<ResultData<RecommendResponse>>

    suspend fun getRelativeProducts(
        token: String,
        productId: String
    ): Flow<ResultData<ProductListResponse>>

    suspend fun getRecommendProducts(
        token: String,
        productId: String
    ): Flow<ResultData<ProductListResponse>>

    suspend fun getPopularSearches(token: String): Flow<ResultData<PopularSearchListResponse>>

    suspend fun getSearchSimilarProducts(
        token: String,
        sid: String,
        productId: String
    ): Flow<ResultData<ProductListResponse>>

    suspend fun getGuestUsersSelfRecommend(
        token: String,
        sid: String,
        requestData: SearchProductRequest
    ): Flow<ResultData<ProductListResponse>>
}
