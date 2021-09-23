package kr.co.kmmmami.domain.repository

import kr.co.kmmmami.domain.model.response.ImagesData
import kr.co.kmmmami.domain.model.response.UrlData

interface AppVersionRepository {

    fun itemCategoryInit()

    fun deleteAppVersion()

    fun setUrlData(dataBean: UrlData?)

    fun setImagesData(
        imagesData: ImagesData?,
        loginImageValue: Int,
        splashImageValue: Int,
    )

    var localVersion: Int
    var urlVersion: Int
    var itemCategory: Int
    var footer: String
    var textVersion: Int

    val privacyUrl: String
    val termsUrl: String
    val faqUrl: String
    val businessInfoUrl: String
    val importPointUrl: String
    val marketingPushUrl: String
    val nightPushUrl: String
//    val thirdPartyOrderUrl: String
    val privacyCollectUseUrl: String
    val thirdPartyUrl: String
    val kidPersonalCollectUseUrl: String
    val privacySignUpUrl: String
    val privacyDateOfBirthUrl: String

    val splashImage: Int
    val loginImage: Int

    val splashImgPath: String
    val loginImagePath: String
}
