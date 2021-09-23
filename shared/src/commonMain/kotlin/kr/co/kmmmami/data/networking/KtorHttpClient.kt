package kr.co.kmmmami.data.networking

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.InternalCoroutinesApi
import kr.co.kmmmami.util.createPlatformKtorLogger
import kr.co.kmmmami.util.createPlatformLogger

/**
 * Created by jangsc@brandi.co.kr on 2021/08/17
 */
class KtorHttpClient {
    val logger = createPlatformLogger("Network")

    @OptIn(InternalCoroutinesApi::class)
    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json {
                isLenient = true
                encodeDefaults = false
                ignoreUnknownKeys = true
                coerceInputValues = true
                prettyPrint = true
            }
            serializer = KotlinxSerializer(json)
        }
        install(Logging) {
            logger = createPlatformKtorLogger("Network")
            level = LogLevel.ALL
        }
//        install(ResponseObserver) {
//            onResponse { response ->
//                logger.d("HTTP status:", "${response.status.value}")
//            }
//        }

        defaultRequest {
            contentType(ContentType.Application.Json)
            parameter("service-type", "mami")
        }
    }

    val client = httpClient
}