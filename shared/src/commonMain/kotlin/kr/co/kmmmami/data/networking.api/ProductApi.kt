package kr.co.kmmmami.data.networking.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import kr.co.kmmmami.data.networking.KtorHttpClient
import kr.co.kmmmami.data.networking.NetworkingConstants

/**
 * Created by jangsc@brandi.co.kr on 2021/08/17
 */
class ProductApi(val ktorHttpClient: KtorHttpClient) {
    val httpClient = ktorHttpClient.client

    suspend fun getProductReviews(token: String, productId: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.API_URL_HOST.plus("products/${productId}/reviews"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getPoint(token: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.API_URL_HOST.plus("users/self/point"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }
}