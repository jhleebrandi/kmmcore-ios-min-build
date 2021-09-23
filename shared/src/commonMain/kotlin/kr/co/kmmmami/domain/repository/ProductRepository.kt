package kr.co.kmmmami.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.domain.model.response.*

interface ProductRepository {

    suspend fun getProductAllReviewList(
        token: String,
        productId: String,
        offset: Int = 0
    ): Flow<ResultData<ProductReviewListResponse>>

    suspend fun getFirstProductPhotoReviewList(
        token: String,
        productId: String,
    ): Flow<ResultData<PhotoReviewListFirstResponse>>

    suspend fun getProductPhotoReviewList(
        token: String,
        productId: String,
        offset: Int = 0
    ): Flow<ResultData<PhotoReviewListResponse>>

    suspend fun getFirstProductTextReviewList(
        token: String,
        productId: String,
    ): Flow<ResultData<TextReviewListFirstResponse>>

    suspend fun getProductTextReviewList(
        token: String,
        productId: String,
        offset: Int = 0
    ): Flow<ResultData<TextReviewListResponse>>

    suspend fun getPoint(
        token: String
    ): Flow<ResultData<PointResponse>>
}
