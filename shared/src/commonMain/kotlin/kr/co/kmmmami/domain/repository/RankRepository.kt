package kr.co.kmmmami.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.domain.model.response.ProductListResponse

interface RankRepository {
    suspend fun getRank(
        token: String,
        storeType: String,
        orderFilter: String
    ): Flow<ResultData<ProductListResponse>>

    suspend fun getCategoryData(
        token: String,
        categoryId: Int,
        storeType: String,
        orderFilter: String
    ): Flow<ResultData<ProductListResponse>>
}
