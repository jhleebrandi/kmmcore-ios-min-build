package kr.co.kmmmami.data.networking.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import kr.co.kmmmami.data.networking.KtorHttpClient
import kr.co.kmmmami.data.networking.NetworkingConstants
import kr.co.kmmmami.domain.model.request.CartRequest

/**
 * Created by jangsc@brandi.co.kr on 2021/08/17
 */
class CartApi(val ktorHttpClient: KtorHttpClient) {
    val httpClient = ktorHttpClient.client

    suspend fun getCartList(token: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("cart"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun putCartCount(token: String, productId: String, count: Long, options: Map<String, String>): HttpResponse {
        return httpClient.put<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("cart/${productId}/count/${count}"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun deleteCart(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.delete<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("cart"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun postCarts(token: String, options: Map<String, String>, request: CartRequest): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("cart"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
            body = request
        }
    }
}