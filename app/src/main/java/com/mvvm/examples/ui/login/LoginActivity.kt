package com.mvvm.examples.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mvvm.examples.R
import com.mvvm.examples.databinding.ActivityLoginBinding
import com.mvvm.examples.di.ViewModelProviderFactory
import com.mvvm.examples.ui.base.BaseActivity
import com.mvvm.examples.ui.main.MainActivity
import javax.inject.Inject

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginModel>(), LoginListener {

    @Inject lateinit var factory : ViewModelProviderFactory
    lateinit var loginModel:LoginModel

    override fun getLayoutId(): Int =R.layout.activity_login

    override fun getBindingVariable(): Int = BR.loginModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginModel.setNavigator(this)
    }

    override fun getViewModel(): LoginModel {
        loginModel = ViewModelProviders.of(this, factory).get(LoginModel::class.java)
        return loginModel
    }

    override fun onMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}
