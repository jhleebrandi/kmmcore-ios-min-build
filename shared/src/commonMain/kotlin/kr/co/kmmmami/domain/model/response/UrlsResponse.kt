package kr.co.kmmmami.domain.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kr.co.kmmmami.core_data.model.Meta
import kr.co.kmmmami.core_data.model.Response

/**
 * Created by jangsc@brandi.co.kr on 12/16/20
 */
@Serializable
data class UrlsResponse(
    @SerialName( "data")
    val data: UrlData? = null,
    @SerialName( "meta")
    override val meta: Meta? = null,
) : Response()

@Serializable
data class UrlData(
    @SerialName("terms_url")
    val termsUrl: String = "",
    @SerialName("privacy_url")
    val privacyUrl: String = "",
    @SerialName("third_party_url")
    val thirdPartyUrl: String = "",
    @SerialName("faq_url")
    val faqUrl: String = "",
    @SerialName("business_info_url")
    val businessInfoUrl: String = "",
    @SerialName("import_point_url")
    val importPointUrl: String = "",
    @SerialName("marketing_push_url")
    val marketingPushUrl: String = "",
    @SerialName("night_push_url")
    val nightPushUrl: String = "",
//    @SerialName("third_party_order_url")
//    var thirdPartyOrderUrl: String? = "", // (구매조건 및 개인정보 제3자 제공)
    @SerialName("privacy_collect_use_url")
    var privacyCollectUseUrl: String? = "", // (개인정보 수집 및 이용에 대한 안내)
    @SerialName("kid_personal_collect_use_url")
    var kidPersonalCollectUseUrl: String? = "", // (아이 정보 수집/이용 동의 안내 웹뷰 url)
    @SerialName("privacy_sign_up_url")
    var privacySignUpUrl: String? = "", // 개인정보 수집 및 이용에 대한 안내 (필수) - 회원가입
    @SerialName("privacy_date_of_birth_url")
    var privacyDateOfBirthUrl: String? = "", // 개인정보 수집 및 이용에 대한 안내 (선택) - 회원가입
)
