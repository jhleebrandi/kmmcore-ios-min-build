package kr.co.kmmmami.data.networking.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import kr.co.kmmmami.data.networking.KtorHttpClient
import kr.co.kmmmami.data.networking.NetworkingConstants

/**
 * Created by jangsc@brandi.co.kr on 2021/08/17
 */
class SearchAPI(val ktorHttpClient: KtorHttpClient) {
    val httpClient = ktorHttpClient.client

    suspend fun getSearchProductsWithTotalCount(token: String, sid: String?, search_keyword: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("search/products/${search_keyword}"))
        {
            headers {
                append("Authorization", token)
                sid?.let {
                    append("Sid", it)
                }
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getSearchProducts(token: String, sid: String?, search_keyword: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("search/products/${search_keyword}"))
        {
            headers {
                append("Authorization", token)
                sid?.let {
                    append("Sid", it)
                }
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getSearchSellers(token: String, sid: String?, search_keyword: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("search/sellers/${search_keyword}"))
        {
            headers {
                append("Authorization", token)
                sid?.let {
                    append("Sid", it)
                }
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getUsersSelfMeta(token: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("users/self/meta"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun getSearchProducts(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("search/products"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }
}