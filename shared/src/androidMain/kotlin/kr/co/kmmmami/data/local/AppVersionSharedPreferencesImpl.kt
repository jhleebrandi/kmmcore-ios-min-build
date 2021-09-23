package kr.co.kmmmami.data.local

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import kr.co.kmmmami.domain.model.response.ImagesData
import kr.co.kmmmami.domain.model.response.UrlData

/**
 * Created by jangsc@brandi.co.kr on 2021/08/24
 */
class AppVersionSharedPreferencesImpl(context: Application): AppVersionSharedPreferences {
    private val sharedPref: SharedPreferences = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)

    override var itemCategory: Int
        get() = sharedPref.getInt(ITEM_CATEGORY, 0)
        set(itemCategory) {
            sharedPref.edit {
                putInt(ITEM_CATEGORY, itemCategory)
            }
        }

    override var loginImage: Int
        get() = sharedPref.getInt(LOGIN_IMAGE, 0)
        set(loginImage) {
            sharedPref.edit {
                putInt(LOGIN_IMAGE, loginImage)
            }
        }

    override var splashImage: Int
        get() = sharedPref.getInt(SPLASH_IMAGE, 0)
        set(splashImage) {
            sharedPref.edit {
                putInt(SPLASH_IMAGE, splashImage)
            }
        }

    override var urlVersion: Int
        get() = sharedPref.getInt(URL_VERSION, -1)
        set(urlVersion) {
            sharedPref.edit {
                putInt(URL_VERSION, urlVersion)
            }
        }

    override val termsUrl: String
        get() = sharedPref.getString(TERMS_URL, "").toString()

    override val kidPersonalCollectUseUrl: String
        get() = sharedPref.getString(KID_PERSONAL_COLLECT_USE_URL, "").toString()

    override val privacyCollectUseUrl: String
        get() = sharedPref.getString(PRIVACY_COLLECT_USE_URL, "").toString()

    override val privacySignUpUrl: String
        get() = sharedPref.getString(PRIVACY_SIGN_UP_URL, "").toString()

    override val privacyDateOfBirthUrl: String
        get() = sharedPref.getString(PRIVACY_DATE_OF_BIRTH_URL, "").toString()

    override val privacyUrl: String
        get() = sharedPref.getString(PRIVACY_URL, "").toString()

    override val thirdPartyUrl: String
        get() = sharedPref.getString(THIRD_PARTY_URL, "").toString()

    override val faqUrl: String
        get() = sharedPref.getString(FAQ_URL, "").toString()

    override val businessInfoUrl: String
        get() = sharedPref.getString(BUSINESS_INFO_URL, "").toString()

    override val importPointUrl: String
        get() = sharedPref.getString(IMPORT_POINT_URL, "").toString()

    override var splashImgPath: String
        get() = sharedPref.getString(SPLASH_IMG_PATH, "").toString()
        set(splashImgPath) {
            sharedPref.edit {
                putString(SPLASH_IMG_PATH, splashImgPath)
            }
        }

    override var loginImgPath: String
        get() = sharedPref.getString(LOGIN_IMG_PATH, "").toString()
        set(loginImgPath) {
            sharedPref.edit {
                putString(LOGIN_IMG_PATH, loginImgPath)
            }
        }

    override var localVersion: Int
        get() = sharedPref.getInt(LOCAL_VERSION_CODE, -1)
        set(localVersion) {
            sharedPref.edit {
                putInt(LOCAL_VERSION_CODE, localVersion)
            }
        }

    override var textVersion: Int
        get() = sharedPref.getInt(TEXT_VERSION, -1)
        set(textVersion) {
            sharedPref.edit {
                putInt(TEXT_VERSION, textVersion)
            }
        }

    override var footer: String
        get() = sharedPref.getString(FOOTER, "").toString()
        set(footer) {
            sharedPref.edit {
                putString(FOOTER, footer)
            }
        }

    override var marketingPushUrl: String
        get() = sharedPref.getString(MARKETING_PUSH_URL, "").toString()
        set(marketingPushUrl) {
            sharedPref.edit {
                putString(MARKETING_PUSH_URL, marketingPushUrl)
            }
        }

    override var nightPushUrl: String
        get() = sharedPref.getString(NIGHT_PUSH_URL, "").toString()
        set(nightPushUrl) {
            sharedPref.edit {
                putString(NIGHT_PUSH_URL, nightPushUrl)
            }
        }

    override fun setUrlData(dataBean: UrlData?) {
        dataBean?.let { data ->
            sharedPref.edit()?.apply {
                sharedPref.edit {
                    putString(TERMS_URL, data.termsUrl)
                    putString(PRIVACY_URL, data.privacyUrl)
                    putString(THIRD_PARTY_URL, data.thirdPartyUrl)
                    putString(FAQ_URL, data.faqUrl)
                    putString(BUSINESS_INFO_URL, data.businessInfoUrl)
                    putString(IMPORT_POINT_URL, data.importPointUrl)
                    putString(MARKETING_PUSH_URL, data.marketingPushUrl)
                    putString(NIGHT_PUSH_URL, data.nightPushUrl)
//                    putString(THIRD_PARTY_ORDER_URL, data.thirdPartyOrderUrl)
                    putString(PRIVACY_COLLECT_USE_URL, data.privacyCollectUseUrl)
                    putString(KID_PERSONAL_COLLECT_USE_URL, data.kidPersonalCollectUseUrl)
                    putString(PRIVACY_SIGN_UP_URL, data.privacySignUpUrl)
                    putString(PRIVACY_DATE_OF_BIRTH_URL, data.privacyDateOfBirthUrl)
                }
            }
        }
    }

    override fun setImagesData(imagesData: ImagesData?, loginImageValue: Int, splashImageValue: Int) {
        imagesData?.let {
            splashImgPath = it.splashImageData?.url ?: ""
            loginImgPath = it.loginImageData?.url ?: ""
            loginImage = loginImageValue
            splashImage = splashImageValue
        }
    }

    override fun itemCategoryInit() {
        itemCategory = 0
    }

    override fun deletAppVersion() {
        sharedPref.edit().clear().apply()
    }

    /**
     * 기존 하이버유저가 컨버팅된 소스로 업데이트시 SharedPreference 데이터유실을 방지하고자
     * 컨벤션에 맞지않지만 기존 하이버의 값과 동일하게 작성
     */
    companion object {
        private const val SHARED_NAME = "App_Version"
        private const val ITEM_CATEGORY = "item_category"
        private const val URL_VERSION = "url_version_v2"
        private const val TERMS_URL = "terms_url"
        private const val PRIVACY_URL = "privacy_url"
        private const val THIRD_PARTY_URL = "third_party_url"
        private const val FAQ_URL = "faq_url"
        private const val BUSINESS_INFO_URL = "business_info_url"
        private const val IMPORT_POINT_URL = "import_point_url"
        private const val LOGIN_IMAGE = "login_image_v3"
        private const val SPLASH_IMAGE = "splash_image_v3"
        private const val SPLASH_IMG_PATH = "splash_img_path"
        private const val LOGIN_IMG_PATH = "intro_img_path"
        private const val LOCAL_VERSION_CODE = "local_version_code"
        private const val TEXT_VERSION = "text_version"
        private const val FOOTER = "footer"
        private const val MARKETING_PUSH_URL = "marketing_push_url"
        private const val NIGHT_PUSH_URL = "night_push_url"
        //        private const val THIRD_PARTY_ORDER_URL = "third_party_order_url"
        private const val PRIVACY_COLLECT_USE_URL = "privacy_collect_use_url"
        private const val KID_PERSONAL_COLLECT_USE_URL = "kid_personal_collect_use_url"
        private const val PRIVACY_SIGN_UP_URL = "privacy_sign_up_url"
        private const val PRIVACY_DATE_OF_BIRTH_URL = "privacy_date_of_birth_url"
    }
}