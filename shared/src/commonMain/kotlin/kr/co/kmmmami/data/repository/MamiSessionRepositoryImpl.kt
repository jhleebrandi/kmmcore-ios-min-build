package kr.co.kmmmami.data.repository

import kr.co.kmmmami.core_data.UserStateType
import kr.co.kmmmami.data.local.MamiSessionSharedPreferences
import kr.co.kmmmami.domain.model.response.AuthAccountData
import kr.co.kmmmami.domain.model.response.MyProfileData
import kr.co.kmmmami.domain.model.response.ProfileModifyData
import kr.co.kmmmami.domain.model.response.PushData
import kr.co.kmmmami.domain.repository.MamiSessionRepository

class MamiSessionRepositoryImpl(
    private val mamiSession: MamiSessionSharedPreferences,
) : MamiSessionRepository {

    override val accessToken: String
        get() = mamiSession.accessToken

    override val isGuest: Boolean
        get() = mamiSession.isGuest

    override val certifiedName: String?
        get() = mamiSession.certifiedName

    override val userPhotoUrl: String
        get() = mamiSession.photoUrl

    override val userNickname: String?
        get() = mamiSession.name

    override val isPushMarketingNotification: Boolean
        get() = mamiSession.isPushMarketingNotification

    override val isPushNightMarketingNotification: Boolean
        get() = mamiSession.isPushNightMarketingNotification

    override val snsType: Int
        get() = mamiSession.snsType

    override val userKeyId: String
        get() = mamiSession.userKeyId

    override var fcmToken: String
        get() = mamiSession.fcmToken
        set(newToken) {
            mamiSession.fcmToken = newToken
        }

    override var height: Int
        get() = mamiSession.height
        set(height) {
            mamiSession.height = height
        }

    override var weight: Int
        get() = mamiSession.weight
        set(weight) {
            mamiSession.weight = weight
        }

    override var abTestType: String
        get() = mamiSession.abTestType
        set(type) {
            mamiSession.abTestType = type
        }

    override val sid: String
        get() = mamiSession.getSid()

    override var deepLink: String
        get() = mamiSession.deepLink
        set(deepLink) {
            mamiSession.deepLink = deepLink
        }

    override var stateType: UserStateType
        get() = mamiSession.stateType
        set(userStateType) {
            mamiSession.stateType = userStateType
        }

    override var isNeedChangePassword: Boolean
        get() = mamiSession.isNeedChangePassword
        set(isNeedChangePassword) {
            mamiSession.isNeedChangePassword = isNeedChangePassword
        }

    override val isRepeatPushPopup: Boolean
        get() = mamiSession.isRepeatPushPopup

    override val repeatPushPopupDay: String
        get() = mamiSession.getRepeatPushPopupDay().toString()

    override val userSignUpPath: String
        get() = mamiSession.getUserSignUpPath() ?: ""

    override fun setAuthAccountData(data: AuthAccountData?, type: Int) {
        data?.let {
            mamiSession.setAuthAccountData(data, type)
        }
    }

    override fun setAuthAccountData(
        accessToken: String?,
        needChangePassword: Boolean,
        socialType: Int
    ) {
        if (accessToken != null) {
            mamiSession.setAuthAccountData(accessToken, needChangePassword, socialType)
        }
    }

    override fun setAiBannerLaterTime(time: Long) {
        mamiSession.setAiBannerLaterTime(time)
    }

    override fun isVisibleAiBanner(): Boolean {
        return mamiSession.isVisibleAiBanner()
    }

    override fun updateUserData(myProfileData: MyProfileData) {
        mamiSession.updateUserData(myProfileData)
    }

    override fun updateUserData(profileModifyData: ProfileModifyData) {
        mamiSession.updateUserData(profileModifyData)
    }

    override fun setPushData(push: PushData?) {
        push?.let {
            mamiSession.setPushMarketingNotification(it.isMarketing)
            mamiSession.setPushNightMarketingNotification(it.isNight)
        }
    }

    override fun setUserSelfService(token: String, snsType: Int) {
        mamiSession.setUserSelfService(token, snsType)
    }

    override fun deleteSession() {
        mamiSession.deleteSession()
    }

    override fun guestAutoLogin() {
        mamiSession.guestAutoLogin()
    }

    override fun setSnsType(snsType: Int) {
        mamiSession.setSnsType(snsType)
    }

    override fun updateAccessToken(accessToken: String) {
        mamiSession.updateAccessToken(accessToken)
    }
}
