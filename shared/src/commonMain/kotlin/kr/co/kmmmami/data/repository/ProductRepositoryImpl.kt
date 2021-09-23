package kr.co.kmmmami.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.co.kmmmami.core_data.base.safeApiCallFlow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.data.networking.api.ProductApi
import kr.co.kmmmami.data.utils.QueryMapKey.IS_FIRST
import kr.co.kmmmami.data.utils.QueryMapKey.TAB_TYPE
import kr.co.kmmmami.data.utils.QueryMapKey.VERSION
import kr.co.kmmmami.data.utils.QueryMapUtils.getPagingQueryMap
import kr.co.kmmmami.domain.model.response.*
import kr.co.kmmmami.domain.repository.ProductRepository

class ProductRepositoryImpl(private val productApi: ProductApi) : ProductRepository {

    override suspend fun getProductAllReviewList(
        token: String,
        productId: String,
        offset: Int,
    ): Flow<ResultData<ProductReviewListResponse>> {
        return flow {
            val queryMap = getPagingQueryMap(offset = offset).apply {
                this[VERSION] = "2101"
            }

            emit(
                safeApiCallFlow {
                    productApi.getProductReviews(token, productId, queryMap)
                }
            )
        }
    }

    override suspend fun getFirstProductPhotoReviewList(
        token: String,
        productId: String,
    ): Flow<ResultData<PhotoReviewListFirstResponse>> {
        return flow {
            val options = getPagingQueryMap(offset = 0).apply {
                this[VERSION] = "2101"
                this[TAB_TYPE] = "photo"
                this[IS_FIRST] = "true"
            }

            emit(
                safeApiCallFlow {
                    productApi.getProductReviews(token, productId, options)
                }
            )
        }
    }

    override suspend fun getProductPhotoReviewList(
        token: String,
        productId: String,
        offset: Int,
    ): Flow<ResultData<PhotoReviewListResponse>> {
        return flow {
            val options = getPagingQueryMap(offset = offset).apply {
                this[VERSION] = "2101"
                this[TAB_TYPE] = "photo"
                this[IS_FIRST] = "false"
            }

            emit(
                safeApiCallFlow {
                    productApi.getProductReviews(token, productId, options)
                }
            )
        }
    }

    override suspend fun getFirstProductTextReviewList(
        token: String,
        productId: String,
    ): Flow<ResultData<TextReviewListFirstResponse>> {
        return flow {
            val options = getPagingQueryMap(offset = 0).apply {
                this[VERSION] = "2101"
                this[TAB_TYPE] = "text"
                this[IS_FIRST] = "true"
            }

            emit(
                safeApiCallFlow {
                    productApi.getProductReviews(token, productId, options)
                }
            )
        }
    }

    override suspend fun getProductTextReviewList(
        token: String,
        productId: String,
        offset: Int,
    ): Flow<ResultData<TextReviewListResponse>> {
        return flow {
            val options = getPagingQueryMap(offset = offset).apply {
                this[VERSION] = "2101"
                this[TAB_TYPE] = "text"
                this[IS_FIRST] = "false"
            }

            emit(
                safeApiCallFlow {
                    productApi.getProductReviews(token, productId, options)
                }
            )
        }
    }

    override suspend fun getPoint(token: String): Flow<ResultData<PointResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    productApi.getPoint(token)
                }
            )
        }
    }
}
