package kr.co.kmmmami.data.networking.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import kr.co.kmmmami.data.networking.KtorHttpClient
import kr.co.kmmmami.data.networking.NetworkingConstants

/**
 * Created by jangsc@brandi.co.kr on 2021/08/17
 */
class LoginCommerceAPI(val ktorHttpClient: KtorHttpClient) {
    val httpClient = ktorHttpClient.client

    suspend fun getImages(token: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("images"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun getCategories(token: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("categories"))
        {
            headers {
                append("Authorization", token)
            }
            parameter("version", "2102")
        }
    }

    suspend fun getUsersSelfSellers(token: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("users/self/sellers"))
        {
            headers {
                append("Authorization", token)
            }
            parameter("type", "all")
            parameter("res-type", "seller-id")
        }
    }

    suspend fun getUsersSelfProductNos(token: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("users/self/product-nos"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }
}