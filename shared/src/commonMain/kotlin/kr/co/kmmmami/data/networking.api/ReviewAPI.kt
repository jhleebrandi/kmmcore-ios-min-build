package kr.co.kmmmami.data.networking.api

import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.JsonObject
import kr.co.kmmmami.data.networking.KtorHttpClient
import kr.co.kmmmami.data.networking.NetworkingConstants

/**
 * Created by jangsc@brandi.co.kr on 2021/08/17
 */
class ReviewAPI(val ktorHttpClient: KtorHttpClient) {
    val httpClient = ktorHttpClient.client

    suspend fun getReviews(token: String, reviewId: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.API_URL_HOST.plus("reviews/${reviewId}"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun getReviewsAdditionalInfo(token: String, map: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.API_URL_HOST.plus("reviews/additional-info"))
        {
            headers {
                append("Authorization", token)
            }
            map.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getItemsLikes(token: String, reviewId: String, map: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.API_URL_HOST.plus("items/${reviewId}/likes"))
        {
            headers {
                append("Authorization", token)
            }
            map.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun postReviews(token: String, jsonBody: JsonObject?, fileList: List<ByteArray>?, fileNameList: List<String>?): HttpResponse {
        if (fileList.isNullOrEmpty()) {
            return httpClient.submitForm(
                url = NetworkingConstants.API_URL_HOST.plus("reviews"),
                formParameters = Parameters.build {
                    append("json", jsonBody.toString())
                },
                encodeInQuery = true
            ) {
                headers {
                    append("Authorization", token)
                }
            }
        } else {
            return httpClient.submitFormWithBinaryData(
                url = NetworkingConstants.API_URL_HOST.plus("reviews"),
                formData = formData {
                    append("json", jsonBody.toString())
                    fileList.forEachIndexed { index, bytes ->
                        append("images[]", bytes, Headers.build {
                            append(HttpHeaders.ContentType, "image/*")
                            append(HttpHeaders.ContentDisposition, fileNameList?.getOrNull(index) ?: "")
                        })
                    }
                }
            ) {
                headers {
                    append("Authorization", token)
                }
            }
        }
    }

    suspend fun postReviewLikes(token: String, reviewId: String): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.API_URL_HOST.plus("items/${reviewId}/likes"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun deleteReview(token: String, reviewId: String): HttpResponse {
        return httpClient.delete<HttpResponse>(NetworkingConstants.API_URL_HOST.plus("reviews/${reviewId}"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun deleteReviewLikes(token: String, reviewId: String): HttpResponse {
        return httpClient.delete<HttpResponse>(NetworkingConstants.API_URL_HOST.plus("reviews/${reviewId}/likes"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun modifyReview(token: String, reviewId: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.API_URL_HOST.plus("reviews/${reviewId}/modify"))
        {
            headers {
                append("Authorization", token)
            }
            body = jsonObject
        }
    }
}