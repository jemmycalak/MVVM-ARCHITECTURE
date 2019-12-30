package com.mvvm.examples.ui.base

import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.AndroidInjection

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel<*>?> : AppCompatActivity() {


    lateinit var binding: T
    var mViewModel:V?=null
    var isCancelable = false
    var isCancelable2 = false

    protected abstract fun getBindingVariable(): Int

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    @LayoutRes
    open fun getLayoutIdLoading(): Int = -1

    open fun getThemResId(): Int = -1

    abstract fun getViewModel(): V

    override fun onCreate(savedInstanceState: Bundle?) {
        performDI()
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDI() =AndroidInjection.inject(this)

    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        mViewModel = if(mViewModel == null) getViewModel() else mViewModel
        binding.setVariable(getBindingVariable(), getViewModel())
        binding.executePendingBindings()
    }

}