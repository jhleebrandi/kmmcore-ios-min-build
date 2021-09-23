package kr.co.kmmmami.domain.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequest(
    @SerialName("name")
    val name: String?,
    @SerialName("email")
    val email: String?,
    @SerialName("password")
    val password: String?,
    @SerialName("device_type")
    val deviceType: String,
    @SerialName("device_code")
    var deviceCode: String? = null,
    @SerialName("type")
    var type: String? = null,
    @SerialName("sns_common_id")
    var snsCommonId: String? = null,
    @SerialName("sns_id")
    val snsId: String?,
    @SerialName("sns_common_id_type")
    var snsCommonIdType: String? = null,
    @SerialName("recommend_code")
    var recommendCode: String? = null,
    @SerialName("agreement")
    val agreement: AgreementItem,
    @SerialName("birth_date")
    val birthDate: String?,
    @SerialName("gender")
    val gender: String?,
    @SerialName("verification_type")
    val verificationType: Int,
    @SerialName("certification_id")
    var certificationId: String? = null,
    @SerialName("telephone")
    var telephone: String? = null,
    @SerialName("verification_result_id")
    var verificationResultId: String? = null,
    @SerialName("is_not_certified")
    var isNotCertified: Boolean? = null,
    @SerialName("facebook_name")
    var facebookName: String? = null,
)

@Serializable
data class AgreementItem(
    @SerialName("push_marketing_receive")
    val pushMarketingReceive: Boolean,
    @SerialName("push_night_receive")
    val pushNightReceive: Boolean,
    @SerialName("terms")
    val terms: Boolean,
    @SerialName("privacy_collect")
    val privacyCollect: Boolean,
)

@Serializable
data class KidItem(
    @SerialName("id")
    val id: String? = null,
    @SerialName("name")
    val name: String,
    @SerialName("sexdstn")
    val sexdstn: String,
    @SerialName("birth")
    val birth: String,
    @SerialName("photo_name")
    val photo_name: String? = null,
    @SerialName("is_deleted")
    val isDeleted: Boolean? = null,
)

@Serializable
data class UserSelfRequest(
    @SerialName("service_type")
    val serviceType: String,
    @SerialName("sns_type")
    val snsType: String?,
    @SerialName("sns_id")
    var snsId: String? = null,
    @SerialName("sns_common_id")
    var snsCommonId: String? = null,
    @SerialName("sns_common_id_type")
    var snsCommonIdType: String? = null,
    @SerialName("verification_type")
    var verificationType: Int? = null,
    @SerialName("certification_id")
    var certificationId: String? = null,
    @SerialName("telephone")
    var telephone: String? = null,
    @SerialName("verification_result_id")
    var verificationResultId: String? = null,
    @SerialName("is_not_certified")
    var isNotCertified: Boolean? = null,
    @SerialName("agreement")
    val agreement: UserSelfAgreementItem,
)

@Serializable
data class UserSelfAgreementItem(
    @SerialName("push_marketing_receive")
    val pushMarketingReceive: Boolean,
    @SerialName("push_night_receive")
    val pushNightReceive: Boolean,
    @SerialName("privacy_provide")
    val privacyProvide: Boolean,
)