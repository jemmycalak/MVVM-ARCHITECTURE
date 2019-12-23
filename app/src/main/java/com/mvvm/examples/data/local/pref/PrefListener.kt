package com.mvvm.examples.data.local.pref

interface PrefListener {

    fun isLogin():Boolean
    fun setLogin(isLogin:Boolean)
    fun logout()
}