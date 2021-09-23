package kr.co.kmmmami.data.local

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import java.util.regex.Pattern

/**
 * Created by jangsc@brandi.co.kr on 2021/08/24
 */
class OrderSessionSharedPreferencesImpl(context: Application): OrderSessionSharedPreferences {
    private val sharedPref: SharedPreferences

    init {
        sharedPref = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)
    }

    override var paymentType: Int
        get() = sharedPref.getInt(KEY_PAY_TYPE, 0)
        set(orderType) {
            sharedPref.edit { putInt(KEY_PAY_TYPE, orderType) }
        }

    override val tossToken: String?
        get() = sharedPref.getString(TOSS_TOKEN, null)

    override val tossStatus: String?
        get() = sharedPref.getString(TOSS_STATUS, null)

    override val tossOrderNumber: String?
        get() = sharedPref.getString(TOSS_ORDER_NO, null)

    override fun deleteSession() {
        sharedPref.edit().clear().commit()
    }

    override fun putTossLink(url: String?) {
        if (url == null) {
            sharedPref.edit { putString(TOSS_TOKEN, null) }
            sharedPref.edit { putString(TOSS_STATUS, null) }
            sharedPref.edit { putString(TOSS_ORDER_NO, null) }
            return
        }
        val urlPattern =
            Pattern.compile("^(mamiapplication?):\\/\\/([^:\\/\\s]+)(:([^\\/]*))?((\\/[^\\s/\\/]+)*)?\\/([^#\\s\\?]*)(\\?([^#\\s]*))?(#(\\w*))?$")
        val matcher = urlPattern.matcher(url)
        if (matcher.matches()) {
            val param = matcher.group(9)
            if (param != null) {
                val token = matcher.group(7)
                if (token != null) {
                    sharedPref.edit { putString(TOSS_TOKEN, token) }
                }
                val paramList = param.split("&".toRegex()).toTypedArray()
                paramList.forEach {
                    val keyValue = it.split("=".toRegex()).toTypedArray()
                    if (keyValue != null && keyValue.size == 2) {
                        val key = keyValue[0]
                        val value = keyValue[1]

                        if (key.equals(STATUS, ignoreCase = true)) {
                            sharedPref.edit { putString(TOSS_STATUS, value) }
                        } else if (key.equals(ORDER_NUMBER, ignoreCase = true)) {
                            sharedPref.edit { putString(TOSS_ORDER_NO, value) }
                        }
                    }
                }
            }
        }
    }

    /**
     * 기존 하이버유저가 컨버팅된 소스로 업데이트시 SharedPreference 데이터유실을 방지하고자
     * 컨벤션에 맞지않지만 기존 하이버의 값과 동일하게 작성
     */
    companion object {
        private const val SHARED_NAME = "order_session_v1"
        private const val KEY_PAY_TYPE = "key_pay_type"
        private const val TOSS_TOKEN = "toss_token"
        private const val TOSS_STATUS = "toss_status"
        private const val TOSS_ORDER_NO = "toss_order_no"
        private const val STATUS = "status"
        private const val ORDER_NUMBER = "orderNo"
    }
}