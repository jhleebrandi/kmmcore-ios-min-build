package kr.co.kmmmami.data.local

import kr.co.kmmmami.domain.model.response.ImagesData
import kr.co.kmmmami.domain.model.response.UrlData

interface AppVersionSharedPreferences {

    var itemCategory: Int

    var loginImage: Int

    var splashImage: Int

    var urlVersion: Int

    val termsUrl: String

    val kidPersonalCollectUseUrl: String

    val privacyCollectUseUrl: String

    val privacySignUpUrl: String

    val privacyDateOfBirthUrl: String

    val privacyUrl: String

    val thirdPartyUrl: String

    val faqUrl: String

    val businessInfoUrl: String

    val importPointUrl: String

    var splashImgPath: String

    var loginImgPath: String

    var localVersion: Int

    var textVersion: Int

    var footer: String

    var marketingPushUrl: String

    var nightPushUrl: String

    fun setUrlData(dataBean: UrlData?)

    fun setImagesData(imagesData: ImagesData?, loginImageValue: Int, splashImageValue: Int)

    fun itemCategoryInit()

    fun deletAppVersion()
}
