package kr.co.kmmmami.data.local

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import kr.co.kmmmami.core_data.UserStateType
import kr.co.kmmmami.domain.model.response.AuthAccountData
import kr.co.kmmmami.domain.model.response.MyProfileData
import kr.co.kmmmami.domain.model.response.ProfileModifyData
import java.util.*

class MamiSessionSharedPreferencesImpl(context:Application) : MamiSessionSharedPreferences {
    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)

    override val userKeyId: String
        get() = sharedPref.getString(USER_ID, "").toString()

    override val isLoggedIn: Boolean
        get() {
            val token = sharedPref.getString(ACCESS_TOKEN, null)
            return token != null
        }

    // 개인 신장. 포토 리뷰 작성시에 사용함.
    override var height: Int
        get() = sharedPref.getInt(HEIGHT, 0)
        set(height) {
            sharedPref.edit { putInt(HEIGHT, height) }
        }

    // 개인 몸무게.
    override var weight: Int
        get() = sharedPref.getInt(WEIGHT, 0)
        set(weight) {
            sharedPref.edit { putInt(WEIGHT, weight) }
        }

    override var abTestType: String
        get() = sharedPref.getString(AB_TEST_TYPE, "")!!
        set(type) {
            sharedPref.edit { putString(AB_TEST_TYPE, type) }
        }

    override val photoUrl: String
        get() = sharedPref.getString(PHOTO_URL, GUEST_PHOTO_URL)!!

    override val isGuest: Boolean
        get() = accessToken.equals(GUEST_TOKEN, ignoreCase = true)

    override var deepLink: String
        get() = sharedPref.getString(DEEP_LINK, "").toString()
        set(value) {
            sharedPref.edit { putString(DEEP_LINK, value) }
        }

    override var accessToken: String
        get() = sharedPref.getString(ACCESS_TOKEN, GUEST_TOKEN)!!
        @Deprecated("")
        set(token) {
            sharedPref.edit { putString(ACCESS_TOKEN, token) }
        }

    override var fcmToken: String
        get() = sharedPref.getString(FCM_TOKEN, "")!!
        set(newToken) {
            sharedPref.edit { putString(FCM_TOKEN, newToken) }
        }

    override val isPushMarketingNotification: Boolean
        get() = sharedPref.getBoolean(PUSH_NOTIFICATION_MARKETING_ON, false)

    override val isPushNightMarketingNotification: Boolean
        get() = sharedPref.getBoolean(PUSH_NOTIFICATION_NIGHT_MARKETING_ON, false)

    override val isRepeatPushPopup: Boolean
        get() = sharedPref.getBoolean(REPEAT_PUSH_POPUP, false)

    override val snsType: Int
        get() = sharedPref.getInt(SNS_LOGIN_TYPE, 0)

    override val name: String?
        get() = sharedPref.getString(USER_NICKNAME, null)

    override val certifiedName: String?
        get() = sharedPref.getString(USER_NAME, null)

    // 1, 인증 2, 휴면 3.탈퇴 4.미인증
    // 2018.06.11 보예 휴면 계정 복구
    override var stateType: UserStateType
        get() {
            val state = sharedPref.getInt(STATE, 0)
            return UserStateType.values()[state]
        }
        set(userStateType) {
            sharedPref.edit { putInt(STATE, userStateType.ordinal) }
        }

    override var isNeedChangePassword: Boolean
        get() = sharedPref.getBoolean(NEED_CHANGE_PASSWORD, false)
        set(isNeedChangePassword) {
            sharedPref.edit { putBoolean(NEED_CHANGE_PASSWORD, isNeedChangePassword) }
        }

    override fun deleteSession() {
        sharedPref.edit().clear().commit()
    }

    override fun guestAutoLogin() {
        if (!isLoggedIn) {
            deleteSession()

            val editor = sharedPref.edit()

            editor.putString(USER_ID, GUEST_ID)
            editor.putString(ACCESS_TOKEN, GUEST_TOKEN)
            editor.putString(USER_NICKNAME, GUEST_NAME)
            editor.putString(PHOTO_URL, GUEST_PHOTO_URL)

            editor.commit()
        }
    }

    override fun updateUserData(myProfileData: MyProfileData) {
        val editor = sharedPref.edit()
        editor.putString(USER_ID, myProfileData.id)
        editor.putString(USER_NAME, myProfileData.certifiedName)
        editor.putString(USER_NICKNAME, myProfileData.name)
        editor.putString(PHOTO_URL, myProfileData.imageUrl)
        editor.putInt(STATE, myProfileData.state)
        editor.putInt(WEIGHT, myProfileData.weight)
        editor.putInt(HEIGHT, myProfileData.height)
        editor.putBoolean(PUSH_NOTIFICATION_ON, myProfileData.isPush)

        editor.putString(USER_SIGN_UP_PATH, myProfileData.signUpPath)

        myProfileData.push?.let { push ->
            editor.putBoolean(PUSH_NOTIFICATION_MARKETING_ON, push.isMarketing)
            editor.putBoolean(PUSH_NOTIFICATION_NIGHT_MARKETING_ON, push.isNight)
            push.popup?.let {
                editor.putInt(REPEAT_PUSH_DAY, it.invisibleDay)
                editor.putBoolean(REPEAT_PUSH_POPUP, it.isVisible)
            }
        }
        editor.commit()
    }

    override fun updateUserData(profileModifyData: ProfileModifyData) {
        val editor = sharedPref.edit()
        editor.putString(USER_ID, profileModifyData.id)
        editor.putString(USER_NICKNAME, profileModifyData.name)
        editor.putString(PHOTO_URL, profileModifyData.imageUrl)
        editor.commit()
    }

    override fun setPushNotificationOn(isPush: Boolean) {
        sharedPref.edit { putBoolean(PUSH_NOTIFICATION_ON, isPush) }
    }

    override fun setPushMarketingNotification(isPush: Boolean) {
        sharedPref.edit { putBoolean(PUSH_NOTIFICATION_MARKETING_ON, isPush) }
    }

    override fun setPushNightMarketingNotification(isPush: Boolean) {
        sharedPref.edit { putBoolean(PUSH_NOTIFICATION_NIGHT_MARKETING_ON, isPush) }
    }

    override fun setRepeatPushPopup(isRepeatPushPopup: Boolean) {
        sharedPref.edit { putBoolean(REPEAT_PUSH_POPUP, isRepeatPushPopup) }
    }

    override fun getRepeatPushPopupDay(): Int {
        return sharedPref.getInt(REPEAT_PUSH_DAY, 7)
    }

    override fun getUserSignUpPath(): String? {
        return sharedPref.getString(USER_SIGN_UP_PATH, null)
    }

    override fun getSid(): String {
        var sid = sharedPref.getString(SID, null)
        if (sid == null || sid.isEmpty()) {
            sid = makeSessionID()
            sharedPref.edit { putString(SID, sid).commit() }
        }
        return sid!!
    }

    // Sid 생성 로직
    private fun makeSessionID(): String? {
        // 자리수
        val size = 32
        val random = Random()
        val sb = StringBuffer()
        for (i in 0 until size) {
            if (random.nextBoolean()) {
                // 랜덤 대문자
                sb.append(((Math.random() * 26).toInt() + 65).toChar())
            } else {
                // 랜덤 숫자
                sb.append(random.nextInt(10))
            }
        }
        return sb.toString()
    }

    override fun setAiBannerLaterTime(time: Long) {
        sharedPref.edit { putLong(AI_BANNER_LATER_TIME, time) }
    }

    override fun isVisibleAiBanner(): Boolean {
        val laterTime = sharedPref.getLong(AI_BANNER_LATER_TIME, 0)

        val current = Calendar.getInstance()
        val laterCalendar = Calendar.getInstance()
        laterCalendar.timeInMillis = laterTime

        // 72시간 후
        laterCalendar.add(Calendar.HOUR_OF_DAY, 72)
        laterCalendar[Calendar.MINUTE] = 0
        laterCalendar[Calendar.SECOND] = 0

        // 현재가 (X 버튼누르고 72시간) 이후이면 true
        return current.after(laterCalendar)
    }

    override fun setAuthAccountData(data: AuthAccountData, socialType: Int) {
        sharedPref.edit {
            putString(USER_ID, data.memberNumber)
            putString(USER_NICKNAME, data.nickname)
            putBoolean(NEED_CHANGE_PASSWORD, data.isChangePassword)
            putString(ACCESS_TOKEN, data.brandiToken)
            putInt(SNS_LOGIN_TYPE, socialType)
        }
    }

    override fun setAuthAccountData(accessToken: String, needChangePassword: Boolean, socialType: Int) {
        sharedPref.edit {
            putString(ACCESS_TOKEN, accessToken)
            putBoolean(NEED_CHANGE_PASSWORD, needChangePassword)
            putInt(SNS_LOGIN_TYPE, socialType)
        }
    }

    override fun setUserSelfService(token: String, snsType: Int) {
        sharedPref.edit {
            putString(ACCESS_TOKEN, token)
            putInt(SNS_LOGIN_TYPE, snsType)
        }
    }

    override fun setSnsType(snsType: Int) {
        sharedPref.edit {
            putInt(SNS_LOGIN_TYPE, snsType)
        }
    }

    override fun updateAccessToken(accessToken: String) {
        sharedPref.edit {
            if (accessToken.isEmpty()) {
                putString(ACCESS_TOKEN, GUEST_TOKEN)
            } else {
                putString(ACCESS_TOKEN, accessToken)
            }
        }
    }

    /**
     * 기존 하이버유저가 컨버팅된 소스로 업데이트시 SharedPreference 데이터유실을 방지하고자
     * 컨벤션에 맞지않지만 기존 하이버의 값과 동일하게 작성
     */
    companion object {
        private const val SHARED_NAME = "Brandi_Login"
        private const val SNS_LOGIN_TYPE = "sns_login_type"

        private const val USER_ID = "id"
        private const val USER_NAME = "user_name"
        private const val USER_NICKNAME = "user_nickname"
        private const val PHOTO_URL = "photo_url"
        private const val WEIGHT = "weight"
        private const val HEIGHT = "height"
        private const val STATE = "state"
        private const val NEED_CHANGE_PASSWORD = "need_change_password"
        private const val AB_TEST_TYPE = "ab_test_type"

        private const val PUSH_NOTIFICATION_ON = "is_push"
        private const val PUSH_NOTIFICATION_MARKETING_ON = "is_push_marketing"
        private const val PUSH_NOTIFICATION_NIGHT_MARKETING_ON = "is_push_night_marketing"
        private const val REPEAT_PUSH_POPUP = "repeat_push_popup"
        private const val REPEAT_PUSH_DAY = "repeat_push_day"

        private const val ACCESS_TOKEN = "access_token"
        private const val FCM_TOKEN = "fcm_token"

        private const val GUEST_ID = "1004"
        private const val GUEST_TOKEN =
            "3b17176f2eb5fdffb9bafdcc3e4bc192b013813caddccd0aad20c23ed272f076_1423639497"
        private const val GUEST_NAME = "guest"
        private const val GUEST_PHOTO_URL = "http://image.brandi.me/common/brandi_logo_S.jpg"

        private const val DEEP_LINK = "deep_link"
        private const val SID = "SID" // 세션id
        private const val AI_BANNER_LATER_TIME = "ai_banner_later_time" // Ai 추천 탭 배너 엑스 누를 시
        private const val USER_SIGN_UP_PATH = "user_signup_path"
    }


}