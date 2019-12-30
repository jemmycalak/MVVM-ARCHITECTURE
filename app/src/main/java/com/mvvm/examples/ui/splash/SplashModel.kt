package com.mvvm.examples.ui.splash

import com.mvvm.examples.data.DataManager
import com.mvvm.examples.ui.base.BaseViewModel
import com.mvvm.examples.utils.scheduler.SchedulerListener
import javax.inject.Inject

class SplashModel(data:DataManager, schedulerListener: SchedulerListener) : BaseViewModel<SplashListener>(data, schedulerListener) {

    fun onCreate(){

        if(dataManager.isLogin()) navigate().onOpenMainActivity()
        else navigate().onLoginActivity()
    }
}