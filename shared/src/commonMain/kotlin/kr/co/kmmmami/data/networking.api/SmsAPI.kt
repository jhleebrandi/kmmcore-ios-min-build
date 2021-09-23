package kr.co.kmmmami.data.networking.api

import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.JsonObject
import kr.co.kmmmami.data.networking.KtorHttpClient
import kr.co.kmmmami.data.networking.NetworkingConstants

/**
 * Created by jangsc@brandi.co.kr on 2021/08/17
 */
class SmsAPI(val ktorHttpClient: KtorHttpClient) {
    val httpClient = ktorHttpClient.client

    suspend fun getSmsCertify(token: String, phoneNumber: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.SMS_API_URL_HOST.plus("sms/certify/${phoneNumber}"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun verifySmsCertify(token: String, phoneNumber: String, certificationKey: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.SMS_API_URL_HOST.plus("sms/certify/${phoneNumber}/${certificationKey}"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun getEmailCertify(token: String, email: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.SMS_API_URL_HOST.plus("sms/certify/${email}"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun getVerifyEmailCode(token: String, email: String, certCode: String): HttpResponse {
        return httpClient.get<HttpResponse>(NetworkingConstants.SMS_API_URL_HOST.plus("email/certify/${email}/${certCode}"))
        {
            headers {
                append("Authorization", token)
            }
        }
    }

    suspend fun postTrackerEvent(token: String, jsonObject: JsonObject): HttpResponse {
        return httpClient.post<HttpResponse>(NetworkingConstants.SMS_API_URL_HOST.plus("tracker/event"))
        {
            headers {
                append("Authorization", token)
            }
            body = jsonObject
        }
    }
}