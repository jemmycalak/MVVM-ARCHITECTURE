package com.mvvm.examples.ui.login

import com.mvvm.examples.data.DataManager
import com.mvvm.examples.ui.base.BaseViewModel
import com.mvvm.examples.utils.scheduler.SchedulerListener
import javax.inject.Inject

class LoginModel(dataManager: DataManager, schedulerListener: SchedulerListener)
    :BaseViewModel<LoginListener>(dataManager, schedulerListener) {

    fun onLogin() {
        dataManager.setLogin(true)
        navigate().onMainActivity()
    }

}