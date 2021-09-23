package kr.co.kmmmami.data.networking

object NetworkingConstants {

    var DOMAIN_TYPE = "STAGE"

    private const val PRODUCTION = "PRODUCTION"
    private const val STAGE = "STAGE"

    // prod v2
    private const val API_URL_HOST_PROD2 = "https://api.mami.co.kr/v2/"
    private const val API_URL_HOST_STAGE2 = "https://msapi.brandi.me/v2/"
    private const val API_URL_HOST_SPRINT_V2 = "https://msapi-sprint.brandi.me/v2/"

    // commerce
    private const val COMMERCE_API_URL_HOST_PROD3 = "https://capi.mami.co.kr/v1/"
    private const val COMMERCE_API_URL_HOST_STAGE3 = "https://msapic.brandi.me/v1/"
    private const val COMMERCE_API_URL_HOST_SPRINT_V1 = "https://msapic-sprint.brandi.me/v1/"

    // recommend
    private const val API_URL_RECOMMEND_PROD = "https://recommendi.brandi.biz/"
    private const val API_URL_RECOMMEND_STAGE = "https://recommendi-stg.brandi.biz/"

    // sms
    private const val MAMI_API_URL_SMS_AUTH_PROD = "https://common.brandi.biz"
    private const val MAMI_API_URL_SMS_AUTH_STAGE = "https://common-stg.brandi.biz"

    private const val APPLE_CLIENT_ID_PROD = "kr.co.mami.signinwithapple"
    private const val APPLE_CLIENT_ID_STAGE = "kr.co.brandi.signinwithapplemami"

    const val MAMI_REQUEST_NOAUTH_VALUE = "noauth"

    val API_URL_HOST = when (DOMAIN_TYPE) {
        PRODUCTION -> API_URL_HOST_PROD2
        STAGE -> API_URL_HOST_STAGE2
        else -> API_URL_HOST_SPRINT_V2
    }

    val COMMERCE_API_URL_HOST = when (DOMAIN_TYPE) {
        PRODUCTION -> COMMERCE_API_URL_HOST_PROD3
        STAGE -> COMMERCE_API_URL_HOST_STAGE3
        else -> COMMERCE_API_URL_HOST_SPRINT_V1
    }

    val RECOMMEND_API_URL_HOST = when (DOMAIN_TYPE) {
        PRODUCTION -> API_URL_RECOMMEND_PROD
        STAGE -> API_URL_RECOMMEND_STAGE
        else -> API_URL_RECOMMEND_STAGE
    }

    val SMS_API_URL_HOST = when (DOMAIN_TYPE) {
        PRODUCTION -> {
            MAMI_API_URL_SMS_AUTH_PROD
        }
        else -> {
            MAMI_API_URL_SMS_AUTH_STAGE
        }
    }

    val APPLE_CLIENT_ID = when (DOMAIN_TYPE) {
        PRODUCTION -> APPLE_CLIENT_ID_PROD
        else -> APPLE_CLIENT_ID_STAGE
    }
}
