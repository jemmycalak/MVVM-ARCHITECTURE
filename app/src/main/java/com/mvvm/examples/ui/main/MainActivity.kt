package com.mvvm.examples.ui.main

import android.os.Bundle
import android.util.Log
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mvvm.examples.R
import com.mvvm.examples.databinding.ActivityMainBinding
import com.mvvm.examples.di.ViewModelProviderFactory
import com.mvvm.examples.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainModel>(), MainListener {

    @Inject lateinit var factor : ViewModelProviderFactory
    lateinit var mainModel: MainModel

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getBindingVariable(): Int = BR.mainModel

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("onUdateUI", "<<<<<<")
        super.onCreate(savedInstanceState)
        mainModel.setNavigator(this)
    }

    override fun getViewModel(): MainModel {
        mainModel = ViewModelProviders.of(this, factor).get(MainModel::class.java)
        return mainModel
    }

}
