package com.mvvm.examples.ui.splash

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mvvm.examples.R
import com.mvvm.examples.databinding.ActivitySplashBinding
import com.mvvm.examples.di.ViewModelProviderFactory
import com.mvvm.examples.ui.base.BaseActivity
import com.mvvm.examples.ui.login.LoginActivity
import com.mvvm.examples.ui.main.MainActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashModel>(), SplashListener {

    @Inject lateinit var viewFactory: ViewModelProviderFactory
    lateinit var mainViewModel: SplashModel

    override fun getLayoutId(): Int =R.layout.activity_splash

    override fun getBindingVariable(): Int= BR.splashModel

    override fun getViewModel(): SplashModel {
        mainViewModel = ViewModelProviders.of(this, viewFactory).get(SplashModel::class.java)
        return mainViewModel
    }

    override fun onOpenMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.setNavigator(this)
        mainViewModel.onCreate()

    }
}
