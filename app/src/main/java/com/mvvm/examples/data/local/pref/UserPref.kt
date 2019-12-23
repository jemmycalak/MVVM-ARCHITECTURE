package com.mvvm.examples.data.local.pref

import android.content.Context
import android.content.SharedPreferences
import com.mvvm.examples.BuildConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPref
@Inject
constructor(context: Context): PrefListener {
    var prefs:SharedPreferences

    val KEY_ISLOGIN="is_login"

    init {
        prefs = context.getSharedPreferences(BuildConfig.VERSION_NAME, Context.MODE_PRIVATE)
    }

    override fun isLogin(): Boolean = prefs.getBoolean(KEY_ISLOGIN, false)
    override fun setLogin(isLogin: Boolean) { prefs.edit().putBoolean(KEY_ISLOGIN, isLogin).apply() }

    override fun logout() {
        prefs.edit().clear().apply()
    }

}