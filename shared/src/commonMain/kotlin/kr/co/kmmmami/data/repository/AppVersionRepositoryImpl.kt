package kr.co.kmmmami.data.repository

import kr.co.kmmmami.data.local.AppVersionSharedPreferences
import kr.co.kmmmami.domain.model.response.ImagesData
import kr.co.kmmmami.domain.model.response.UrlData
import kr.co.kmmmami.domain.repository.AppVersionRepository
import kr.co.kmmmami.domain.repository.LoginModuleAppVersionRepository

class AppVersionRepositoryImpl(private val appVersion: AppVersionSharedPreferences) :
    AppVersionRepository, LoginModuleAppVersionRepository {

    override fun itemCategoryInit() {
        appVersion.itemCategoryInit()
    }

    override fun deleteAppVersion() {
        appVersion.deletAppVersion()
    }

    override fun setUrlData(dataBean: UrlData?) {
        appVersion.setUrlData(dataBean)
    }

    override fun setImagesData(
        imagesData: ImagesData?,
        loginImageValue: Int,
        splashImageValue: Int,
    ) {
        appVersion.setImagesData(imagesData, loginImageValue, splashImageValue)
    }

    override var localVersion: Int
        get() = appVersion.localVersion
        set(value) {
            appVersion.localVersion = value
        }

    override var urlVersion: Int
        get() = appVersion.urlVersion
        set(value) {
            appVersion.urlVersion = value
        }

    override var itemCategory
        get() = appVersion.itemCategory
        set(value) {
            appVersion.itemCategory = value
        }

    override var footer: String
        get() = appVersion.footer
        set(value) {
            appVersion.footer = value
        }

    override var textVersion
        get() = appVersion.textVersion
        set(value) {
            appVersion.textVersion = value
        }

    override val privacyUrl: String
        get() = appVersion.privacyUrl

    override val termsUrl: String
        get() = appVersion.termsUrl

    override val faqUrl: String
        get() = appVersion.faqUrl

    override val businessInfoUrl: String
        get() = appVersion.businessInfoUrl

    override val importPointUrl: String
        get() = appVersion.importPointUrl

    override val marketingPushUrl: String
        get() = appVersion.marketingPushUrl

    override val nightPushUrl: String
        get() = appVersion.nightPushUrl

    override val privacyCollectUseUrl: String
        get() = appVersion.privacyCollectUseUrl

    override val privacySignUpUrl: String
        get() = appVersion.privacySignUpUrl

    override val privacyDateOfBirthUrl: String
        get() = appVersion.privacyDateOfBirthUrl

//    override val thirdPartyOrderUrl: String
//        get() = appVersion.thirdPartyOrderUrl

    override val thirdPartyUrl: String
        get() = appVersion.thirdPartyUrl

    override val kidPersonalCollectUseUrl: String
        get() = appVersion.kidPersonalCollectUseUrl

    override val splashImage
        get() = appVersion.splashImage

    override val loginImage
        get() = appVersion.loginImage

    override val loginImagePath
        get() = appVersion.loginImgPath

    override val splashImgPath: String
        get() = appVersion.splashImgPath
}
