package kr.co.kmmmami.data.local

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.russhwolf.settings.AndroidSettings

/**
 * Created by jangsc@brandi.co.kr on 2021/09/06
 */
class AppVersionSetting(context: Application) {
    private val sharedPref: SharedPreferences = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)
    val settings = AndroidSettings(sharedPref)
    private val settingsRepository by lazy {
        SettingsRepository(settings)
    }

    companion object {
        private const val SHARED_NAME = "App_Version"
    }
}