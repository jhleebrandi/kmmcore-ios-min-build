package kr.co.kmmmami.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.domain.model.response.*

interface CouponRepository {
    suspend fun getCouponsCount(
        token: String
    ): Flow<ResultData<CouponCountResponse>>

    suspend fun getCoupons(
        token: String,
        tabType: String,
        offset: Int
    ): Flow<ResultData<CouponListResponse>>

    suspend fun getCouponsWithBenefits(
        token: String,
        tabType: String,
        offset: Int
    ): Flow<ResultData<CouponWithBenefitsMyListResponse>>

    suspend fun postCouponEnroll(
        token: String,
        code: String
    ): Flow<ResultData<CouponDownloadResponse>>

    suspend fun getCouponAvailableProducts(
        token: String,
        couponId: String,
        type: String?,
        offset: Int
    ): Flow<ResultData<ProductListResponse>>

    suspend fun getCouponAvailableProductsWithTotalCount(
        token: String,
        couponId: String,
        type: String?,
        offset: Int
    ): Flow<ResultData<CouponAvailableProductWithTotalCountResponse>>

    suspend fun getCartCount(token: String): Flow<ResultData<CartCountResponse>>

    suspend fun postCouponDownload(
        token: String,
        couponId: String
    ): Flow<ResultData<CouponDownloadResponse>>

    suspend fun postCouponsMultipleDownload(
        token: String,
        couponList: List<String>,
    ): Flow<ResultData<CouponMultipleListResponse>>
}
