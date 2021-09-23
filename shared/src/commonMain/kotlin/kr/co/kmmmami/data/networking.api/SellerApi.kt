package kr.co.kmmmami.data.networking.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import kr.co.kmmmami.data.networking.KtorHttpClient
import kr.co.kmmmami.data.networking.NetworkingConstants

/**
 * Created by jangsc@brandi.co.kr on 2021/08/17
 */
class SellerApi(val ktorHttpClient: KtorHttpClient) {
    val httpClient = ktorHttpClient.client

    suspend fun getSellerWithProducts(token: String, sellerId: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("sellers/${sellerId}/products"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getSearchSellerProducts(token: String, sellerId: String, keyword: String, options: Map<String, String>, sid: String?): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("search/sellers/${sellerId}/products/${keyword}"))
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
}