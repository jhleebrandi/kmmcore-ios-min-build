package kr.co.kmmmami.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.add
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonArray
import kr.co.kmmmami.core_data.model.ResultData
import kr.co.kmmmami.core_data.base.safeApiCallFlow
import kr.co.kmmmami.data.networking.api.CouponApi
import kr.co.kmmmami.data.utils.QueryMapKey.DEVICE_TYPE
import kr.co.kmmmami.data.utils.QueryMapKey.IS_FIRST
import kr.co.kmmmami.data.utils.QueryMapKey.RES_TYPE
import kr.co.kmmmami.data.utils.QueryMapKey.TAB_TYPE
import kr.co.kmmmami.data.utils.QueryMapUtils.getPagingQueryMap
import kr.co.kmmmami.domain.model.response.*
import kr.co.kmmmami.domain.repository.CouponRepository

class CouponRepositoryImpl(
    private val couponApi: CouponApi,
) : CouponRepository {
    override suspend fun getCouponsCount(
        token: String,
    ): Flow<ResultData<CouponCountResponse>> {
        return flow {
            val queryMap = HashMap<String, String>().apply {
                this[DEVICE_TYPE] = "android"
            }

            emit(
                safeApiCallFlow {
                    couponApi.getCouponsCount(token, queryMap)
                }
            )
        }
    }

    override suspend fun getCoupons(
        token: String,
        tabType: String,
        offset: Int,
    ): Flow<ResultData<CouponListResponse>> {
        return flow {
            val queryMap = getPagingQueryMap(offset = offset).apply {
                this[TAB_TYPE] = tabType
                this[DEVICE_TYPE] = "android"
            }

            emit(
                safeApiCallFlow {
                    couponApi.getCoupons(token, queryMap)
                }
            )
        }
    }

    override suspend fun getCouponsWithBenefits(
        token: String,
        tabType: String,
        offset: Int,
    ): Flow<ResultData<CouponWithBenefitsMyListResponse>> {
        return flow {
            val queryMap = getPagingQueryMap(offset = offset).apply {
                this[IS_FIRST] = (offset == 0).toString()
                this[TAB_TYPE] = tabType
                this[DEVICE_TYPE] = "android"
            }

            emit(
                safeApiCallFlow {
                    couponApi.getCouponsWithBenefits(token, queryMap)
                }
            )
        }
    }

    override suspend fun postCouponEnroll(
        token: String,
        code: String,
    ): Flow<ResultData<CouponDownloadResponse>> {
        return flow {
            val jsonObject = buildJsonObject {
                put("code", code)
            }

            emit(
                safeApiCallFlow {
                    couponApi.postCouponEnroll(token, jsonObject)
                }
            )
        }
    }

    override suspend fun getCouponAvailableProducts(
        token: String,
        couponId: String,
        type: String?,
        offset: Int,
    ): Flow<ResultData<ProductListResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    couponApi.getCouponAvailableProducts(
                        token,
                        couponId,
                        getPagingQueryMap(offset = offset)
                    )
                }
            )
        }
    }

    override suspend fun getCouponAvailableProductsWithTotalCount(
        token: String,
        couponId: String,
        type: String?,
        offset: Int,
    ): Flow<ResultData<CouponAvailableProductWithTotalCountResponse>> {
        return flow {
            val queryMap = getPagingQueryMap(offset = offset).apply {
                this[IS_FIRST] = (offset == 0).toString()

                if (type != null)
                    this[RES_TYPE] = type
            }

            emit(
                safeApiCallFlow {
                    couponApi.getCouponAvailableProductsWithTotalCount(token, couponId, queryMap)
                }
            )
        }
    }

    override suspend fun getCartCount(token: String): Flow<ResultData<CartCountResponse>> {
        return flow {
            emit(
                safeApiCallFlow {
                    couponApi.getCartCount(token)
                }
            )
        }
    }

    override suspend fun postCouponDownload(
        token: String,
        couponId: String,
    ): Flow<ResultData<CouponDownloadResponse>> {
        return flow {
            val jsonObject = buildJsonObject {
                put("id", couponId)
            }

            emit(
                safeApiCallFlow {
                    couponApi.postCouponDownload(token, jsonObject)
                }
            )
        }
    }

    override suspend fun postCouponsMultipleDownload(
        token: String,
        couponList: List<String>,
    ): Flow<ResultData<CouponMultipleListResponse>> {
        return flow {
            val jsonObject = buildJsonObject {
                put("type", "event")
                putJsonArray("ids") {
                    for (coupon in couponList) {
                        add(coupon)
                    }
                }
            }

            emit(
                safeApiCallFlow {
                    couponApi.postCouponsMultipleDownload(token, jsonObject)
                }
            )
        }
    }
}
