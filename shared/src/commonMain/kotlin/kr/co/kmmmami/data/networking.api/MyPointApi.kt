package kr.co.kmmmami.data.networking.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.JsonObject
import kr.co.kmmmami.data.networking.KtorHttpClient
import kr.co.kmmmami.data.networking.NetworkingConstants

/**
 * Created by jangsc@brandi.co.kr on 2021/08/17
 */
class MyPointApi(val ktorHttpClient: KtorHttpClient) {
    val httpClient = ktorHttpClient.client

    suspend fun getPoint(token: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.API_URL_HOST.plus("users/self/point"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun getSelfPoints(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.API_URL_HOST.plus("users/self/point"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun postCouponsPoint(token: String, bean: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.API_URL_HOST.plus("coupons/point"))
        {
            headers {
                append("Authorization", token)
            }
            body = bean
        }
    }
}