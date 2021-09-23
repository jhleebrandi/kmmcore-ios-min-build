package kr.co.kmmmami.data.local

import kr.co.kmmmami.core_data.UserStateType
import kr.co.kmmmami.domain.model.response.AuthAccountData
import kr.co.kmmmami.domain.model.response.MyProfileData
import kr.co.kmmmami.domain.model.response.ProfileModifyData

interface MamiSessionSharedPreferences {
    val userKeyId: String

    val isLoggedIn: Boolean

    // 개인 신장. 포토 리뷰 작성시에 사용함.
    var height: Int

    // 개인 몸무게.
    var weight: Int

    var abTestType: String

    val photoUrl: String

    val isGuest: Boolean

    var deepLink: String

    var accessToken: String

    var fcmToken: String

    val isPushMarketingNotification: Boolean

    val isPushNightMarketingNotification: Boolean

    val isRepeatPushPopup: Boolean

    val snsType: Int

    val name: String?

    val certifiedName: String?

    // 1, 인증 2, 휴면 3.탈퇴 4.미인증
    // 2018.06.11 보예 휴면 계정 복구
    var stateType: UserStateType

    var isNeedChangePassword: Boolean

    fun deleteSession()

    fun guestAutoLogin()

    fun updateUserData(myProfileData: MyProfileData)

    fun updateUserData(profileModifyData: ProfileModifyData)

    fun setPushNotificationOn(isPush: Boolean)

    fun setPushMarketingNotification(isPush: Boolean)

    fun setPushNightMarketingNotification(isPush: Boolean)

    fun setRepeatPushPopup(isRepeatPushPopup: Boolean)

    fun getRepeatPushPopupDay(): Int

    fun getUserSignUpPath(): String?

    fun getSid(): String

    // Sid 생성 로직
//    private fun makeSessionID(): String?

    fun setAiBannerLaterTime(time: Long)

    fun isVisibleAiBanner(): Boolean

    fun setAuthAccountData(data: AuthAccountData, socialType: Int)

    fun setAuthAccountData(accessToken: String, needChangePassword: Boolean, socialType: Int)

    fun setUserSelfService(token: String, snsType: Int)

    fun setSnsType(snsType: Int)

    fun updateAccessToken(accessToken: String)
}
