package com.mvvm.examples.di.builder

import com.mvvm.examples.ui.login.LoginActivity
//import com.mvvm.examples.ui.login.LoginModule
import com.mvvm.examples.ui.main.MainActivity
//import com.mvvm.examples.ui.main.MainModule
//import com.mvvm.examples.ui.splash.SplashModule
import com.mvvm.examples.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindLoginActivity():LoginActivity

    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun bindMainActivity():MainActivity
}