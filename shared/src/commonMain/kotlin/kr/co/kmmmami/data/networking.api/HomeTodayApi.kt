package kr.co.kmmmami.data.networking.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import kr.co.kmmmami.data.networking.KtorHttpClient
import kr.co.kmmmami.data.networking.NetworkingConstants

/**
 * Created by jangsc@brandi.co.kr on 2021/08/17
 */
class HomeTodayApi(val ktorHttpClient: KtorHttpClient) {
    val httpClient = ktorHttpClient.client

    suspend fun getMain(token: String, options: Map<String, String>, sid: String? = null): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("main"))
        {
            headers {
                append("Authorization", token)
                sid?.let {
                    append("Sid", it)
                }
            }
            parameter("version", "204")
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }
}