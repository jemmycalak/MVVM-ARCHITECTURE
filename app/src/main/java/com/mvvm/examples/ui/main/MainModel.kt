package com.mvvm.examples.ui.main

import com.mvvm.examples.data.DataManager
import com.mvvm.examples.ui.base.BaseViewModel
import javax.inject.Inject

class MainModel(dataManager: DataManager) : BaseViewModel<MainListener>(dataManager){

    fun onCreate() {
        //dataManager.
    }
}