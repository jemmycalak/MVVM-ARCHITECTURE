package com.mvvm.examples.di.module

import android.content.Context
import com.mvvm.examples.data.AppDataManager
import com.mvvm.examples.data.DataManager
import com.mvvm.examples.data.local.pref.PrefListener
import com.mvvm.examples.data.local.pref.UserPref
import com.mvvm.examples.data.online.ApiManager
import com.mvvm.examples.data.online.Presenter
import com.mvvm.examples.ui.base.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app:App): Context = app

    @Provides
    @Singleton
    fun providePref(pref:UserPref):PrefListener = pref

    @Provides
    @Singleton
    fun provideDataManager(dataManager:AppDataManager):DataManager = dataManager

    @Provides
    @Singleton
    fun providePresenter(presenter:Presenter):ApiManager = presenter

}