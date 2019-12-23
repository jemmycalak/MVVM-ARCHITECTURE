package com.mvvm.examples.ui.login

import com.mvvm.examples.data.DataManager
import com.mvvm.examples.ui.base.BaseViewModel
import javax.inject.Inject

class LoginModel(dataManager: DataManager)
    :BaseViewModel<LoginListener>(dataManager) {
    init {
        onLogin()
    }
    fun onLogin() {
        dataManager.setLogin(true)
        navigate().onMainActivity()
    }

}