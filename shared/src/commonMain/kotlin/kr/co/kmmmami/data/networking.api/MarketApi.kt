package kr.co.kmmmami.data.networking.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.JsonObject
import kr.co.kmmmami.data.networking.KtorHttpClient
import kr.co.kmmmami.data.networking.NetworkingConstants
import kr.co.kmmmami.domain.model.request.OrderBodyRequest

/**
 * Created by jangsc@brandi.co.kr on 2021/08/17
 */
class MarketApi(val ktorHttpClient: KtorHttpClient) {
    val httpClient = ktorHttpClient.client

    suspend fun getProductsByAll(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("main"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getCategoryProductList(token: String, categoryId: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("categories/${categoryId}/products"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getFashionProductsByAll(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("fashion/products"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getBabyProductsByAll(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("baby/products"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getLifeProductsByAll(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("life/products"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getInfantProductsByAll(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("infant/products"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getMaternityProductsByAll(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("maternity/products"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getMyBanners(token: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("banners"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun getAlarms(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("alarms"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun postAlarmsDefault(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("alarms/default"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getProductInfo(token: String, product_id: String?, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("products/").plus(product_id))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getProductsInquiriesWithCount(token: String, product_id: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("products/${product_id}/inquiries"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun postProductsInquiries(token: String, product_id: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("products/${product_id}/inquiries"))
        {
            headers {
                append("Authorization", token)
            }
            body = jsonObject
        }
    }

    suspend fun postProductsBookmark(token: String, product_id: String): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("products/${product_id}/bookmarks"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun deleteProductsBookmark(token: String, product_id: String): HttpResponse {
        return httpClient.delete<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("products/${product_id}/bookmarks"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun getUserSelfProducts(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("users/self/products"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getUserSelfSellers(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("users/self/sellers/main"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun deleteStoreBookmark(token: String, seller_id: String): HttpResponse {
        return httpClient.delete<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("sellers/${seller_id}/bookmarks"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun postStoreBookmark(token: String, seller_id: String): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("sellers/${seller_id}/bookmarks"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun postStoreBookmarkList(token: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("sellers/multiple/bookmarks"))
        {
            headers {
                append("Authorization", token)
            }
            body = jsonObject
        }
    }

    suspend fun postCouponDownload(token: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("coupons/download"))
        {
            headers {
                append("Authorization", token)
            }
            body = jsonObject
        }
    }

    suspend fun getTagsProduct(token: String, tagId: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("tags/${tagId}/products"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getTagsProductByName(token: String, tagName: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("tags/tagname/${tagName}/products"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getSellersMain(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("sellers/main"))
        {
            headers {
                append("Authorization", token)
            }
            parameter("version", "204")
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun getOrdersTemporary(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("orders/temporary"))
        {
            headers {
                append("Authorization", token)
            }
            parameter("version", "204")
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun postDeliveryAddresses(token: String, jsonObject: JsonObject?): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("delivery/addresses"))
        {
            headers {
                append("Authorization", token)
            }
            jsonObject?.let {
                body = jsonObject
            }
        }
    }

    suspend fun putDeliveryAddresses(token: String, addressId: String?, jsonObject: JsonObject?): HttpResponse {
        return httpClient.put<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("delivery/addresses/").plus(addressId))
        {
            headers {
                append("Authorization", token)
            }
            jsonObject?.let {
                body = jsonObject
            }
        }
    }

    suspend fun getDeliveryAddress(token: String, options: Map<String, String>): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("delivery/addresses"))
        {
            headers {
                append("Authorization", token)
            }
            options.forEach {
                parameter(it.key, it.value)
            }
        }
    }

    suspend fun deleteDeliveryAddresses(token: String, addressId: String?): HttpResponse {
        return httpClient.delete<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("delivery/addresses").plus(addressId))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun postDeliveryAddressesIdRequestInfo(token: String, addressId: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("delivery/addresses/${addressId}/request-info"))
        {
            headers {
                append("Authorization", token)
            }
            body = jsonObject
        }
    }

    suspend fun postCheckout(token: String, request: OrderBodyRequest): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("checkout"))
        {
            headers {
                append("Authorization", token)
            }
            body = request
        }
    }

    suspend fun getCheckoutComplete(token: String, checkoutId: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.COMMERCE_API_URL_HOST.plus("checkout/${checkoutId}/complete"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }
}