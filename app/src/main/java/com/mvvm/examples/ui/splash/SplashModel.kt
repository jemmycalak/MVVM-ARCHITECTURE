package com.mvvm.examples.ui.splash

import com.mvvm.examples.data.DataManager
import com.mvvm.examples.ui.base.BaseViewModel
import javax.inject.Inject

class SplashModel(data:DataManager)
    : BaseViewModel<SplashListener>(data) {

    init {
        onCreate()
    }
    fun onCreate(){
        if(dataManager.isLogin()) navigate().onOpenMainActivity()
        else navigate().onLoginActivity()
    }
}