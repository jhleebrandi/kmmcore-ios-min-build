package kr.co.kmmmami.domain.repository

import kr.co.kmmmami.core_data.UserStateType
import kr.co.kmmmami.domain.model.response.AuthAccountData
import kr.co.kmmmami.domain.model.response.MyProfileData
import kr.co.kmmmami.domain.model.response.ProfileModifyData
import kr.co.kmmmami.domain.model.response.PushData

interface MamiSessionRepository {
    val accessToken: String
    val isGuest: Boolean
    val certifiedName: String?
    val userPhotoUrl: String?
    val userNickname: String?
    val userKeyId: String
    var fcmToken: String
    val isPushMarketingNotification: Boolean
    val isPushNightMarketingNotification: Boolean
    val snsType: Int
    val sid: String
    var height: Int
    var weight: Int
    var abTestType: String

    var deepLink: String
    // 1.인증 2.휴면 3.탈퇴 4.미인증
    // 2018.06.11 보예 휴면 계정 복구
    var stateType: UserStateType

    var isNeedChangePassword: Boolean
    val isRepeatPushPopup: Boolean

    val repeatPushPopupDay: String

    val userSignUpPath: String

    fun setAuthAccountData(data: AuthAccountData?, type: Int)
    fun setAuthAccountData(accessToken: String?, needChangePassword: Boolean, socialType: Int)

    fun setAiBannerLaterTime(time: Long)
    fun isVisibleAiBanner(): Boolean

    fun updateUserData(myProfileData: MyProfileData)
    fun updateUserData(profileModifyData: ProfileModifyData)
    fun setPushData(push: PushData?)

    fun setUserSelfService(token: String, snsType: Int)

    fun deleteSession()
    fun guestAutoLogin()

    fun setSnsType(snsType: Int)
    fun updateAccessToken(accessToken: String)
}
