package kr.co.kmmmami.data.networking.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import kr.co.kmmmami.data.networking.KtorHttpClient
import kr.co.kmmmami.data.networking.NetworkingConstants

/**
 * Created by jangsc@brandi.co.kr on 2021/08/17
 */
class RecommendAPI(val ktorHttpClient: KtorHttpClient) {
    val httpClient = ktorHttpClient.client

    suspend fun getUserSelfRecommend(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.RECOMMEND_API_URL_HOST.plus("users/self/recommend"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getRelativeProducts(token: String, product_id: String?, limit: String = "10"): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.RECOMMEND_API_URL_HOST.plus("search/visual/products/").plus(product_id))
        {
            headers {
                append("Authorization", token)
            }
            parameter("limit", limit)
        }
    }

    suspend fun getRecommendProducts(token: String, productId: String?, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.RECOMMEND_API_URL_HOST.plus("recommend/products/").plus(productId))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getPopularSearches(token: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.RECOMMEND_API_URL_HOST.plus("popular/searches"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun getSearchSimilarProducts(token: String, sid: String?, productId: String?, options: Map<String, String>?): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.RECOMMEND_API_URL_HOST.plus("recommend/products/").plus(productId))
        {
            headers {
                append("Authorization", token)
                sid?.let {
                    append("Sid", it)
                }
            }
            options?.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getGuestUserSelfRecommend(token: String, sid: String?, options: Map<String, String>?): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.RECOMMEND_API_URL_HOST.plus("users/self/recommend"))
        {
            headers {
                append("Authorization", token)
                sid?.let {
                    append("Sid", it)
                }
            }
            options?.forEach {
                parameter(it.key, it.value)
            }
        }
    }
}