package kr.co.kmmmami.data.networking.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.JsonObject
import kr.co.kmmmami.data.networking.KtorHttpClient
import kr.co.kmmmami.data.networking.NetworkingConstants

/**
 * Created by jangsc@brandi.co.kr on 2021/08/17
 */
class MyDeliveryApi(val ktorHttpClient: KtorHttpClient) {
    val httpClient = ktorHttpClient.client

    suspend fun getDeliveryList(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("orders"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getOrderDetail(token: String, orderId: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("orders/${orderId}/detail"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun getOrdersDetailByOrderDetailIdCancel(token: String, orderId: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("orders/detail/${orderId}/cancel"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun getOrdersDetailByOrderDetailIdRefund(token: String, orderId: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("orders/detail/${orderId}/refund"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun postOrdersDetailByOrderDetailIdCancel(token: String, orderId: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("orders/detail/${orderId}/cancel"))
        {
            headers {
                append("Authorization", token)
            }
            body = jsonObject
        }
    }

    suspend fun postOrdersDetailByOrderDetailIdRefund(token: String, orderId: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("orders/detail/${orderId}/refund"))
        {
            headers {
                append("Authorization", token)
            }
            body = jsonObject
        }
    }

    suspend fun deleteOrderCancel(token: String, orderId: String): HttpResponse {
        return httpClient.delete<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("orders/detail/${orderId}/cancel"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun deleteOrderRefund(token: String, orderId: String): HttpResponse {
        return httpClient.delete<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("orders/detail/${orderId}/refund"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun postOrderConfirm(token: String, orderId: String): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("orders/detail/${orderId}/confirm"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun putOrdersCancel(token: String, orderId: String): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("orders/detail/${orderId}/cancel"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }
}