package kr.co.kmmmami.data.networking.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import kr.co.kmmmami.data.networking.KtorHttpClient
import kr.co.kmmmami.data.networking.NetworkingConstants

/**
 * Created by jangsc@brandi.co.kr on 2021/08/17
 */
class HomeEventApi(val ktorHttpClient: KtorHttpClient) {
    val httpClient = ktorHttpClient.client

    suspend fun getEvent(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("events"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getEventById(token: String, eventId: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("events/${eventId}"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getEventProductsById(token: String, eventId: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("events/${eventId}/products"))
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