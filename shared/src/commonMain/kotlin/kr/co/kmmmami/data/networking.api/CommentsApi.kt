package kr.co.kmmmami.data.networking.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.JsonObject
import kr.co.kmmmami.data.networking.KtorHttpClient
import kr.co.kmmmami.data.networking.NetworkingConstants

/**
 * Created by jangsc@brandi.co.kr on 2021/08/17
 */
class CommentsApi(val ktorHttpClient: KtorHttpClient) {
    val httpClient = ktorHttpClient.client

    suspend fun getEventsComments(token: String, eventId: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.API_URL_HOST.plus("events/${eventId}/comments"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun postEventsComments(token: String, eventId: String, request: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.API_URL_HOST.plus("events/${eventId}/comments"))
        {
            headers {
                append("Authorization", token)
            }
            body = request
        }
    }

    suspend fun deleteEventsComments(token: String, eventId: String, commentsId: String): HttpResponse {
        return httpClient.delete<HttpResponse>(NetworkingConstants.API_URL_HOST.plus("events/${eventId}/comments/${commentsId}"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun getReviewsComments(token: String, reviewId: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.API_URL_HOST.plus("reviews/${reviewId}/comments"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun postReviewsComments(token: String, reviewId: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.API_URL_HOST.plus("reviews/${reviewId}/comments"))
        {
            headers {
                append("Authorization", token)
            }
            body = jsonObject
        }
    }

    suspend fun deleteReviewsComments(token: String, reviewId: String, commentsId: String): HttpResponse {
        return httpClient.delete<HttpResponse>(NetworkingConstants.API_URL_HOST.plus("reviews/${reviewId}/comments/${commentsId}"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }
}