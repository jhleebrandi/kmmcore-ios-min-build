package kr.co.kmmmami.data.networking.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.JsonObject
import kr.co.kmmmami.data.networking.KtorHttpClient
import kr.co.kmmmami.data.networking.NetworkingConstants

/**
 * Created by jangsc@brandi.co.kr on 2021/08/17
 */
class CouponApi(val ktorHttpClient: KtorHttpClient) {
    val httpClient = ktorHttpClient.client

    suspend fun getCouponsCount(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("coupons/count"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getCoupons(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("coupons"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getCouponsWithBenefits(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("coupons"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun postCouponEnroll(token: String, bean: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("coupons/download"))
        {
            headers {
                append("Authorization", token)
            }
            body = bean
        }
    }

    suspend fun getCouponAvailableProducts(token: String, couponId: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("coupon/${couponId}/products"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getCouponAvailableProductsWithTotalCount(token: String, couponId: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("coupon/${couponId}/products"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getCartCount(token: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("cart/count"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun postCouponDownload(token: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("coupons/download"))
        {
            headers {
                append("Authorization", token)
            }
            body = jsonObject
        }
    }

    suspend fun postCouponsMultipleDownload(token: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("coupons/multiple/download"))
        {
            headers {
                append("Authorization", token)
            }
            body = jsonObject
        }
    }
}