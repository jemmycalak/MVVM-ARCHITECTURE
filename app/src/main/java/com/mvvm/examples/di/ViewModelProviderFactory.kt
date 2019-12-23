package com.mvvm.examples.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mvvm.examples.data.DataManager
import com.mvvm.examples.ui.login.LoginModel
import com.mvvm.examples.ui.main.MainModel
import com.mvvm.examples.ui.splash.SplashModel
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelProviderFactory @Inject constructor(val dataManager: DataManager) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SplashModel::class.java)) return SplashModel(dataManager) as T
        else if(modelClass.isAssignableFrom(LoginModel::class.java)) return LoginModel(dataManager) as T
        else if(modelClass.isAssignableFrom(MainModel::class.java)) return MainModel(dataManager) as T

        throw IllegalArgumentException("Unknown class name")
    }
}