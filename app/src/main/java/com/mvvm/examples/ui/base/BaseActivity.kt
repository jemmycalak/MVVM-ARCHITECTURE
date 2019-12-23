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

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    @LayoutRes
    open fun getLayoutIdLoading(): Int = -1

    open fun getThemResId(): Int = -1

    protected abstract fun getBindingVariable(): Int

    //protected abstract fun updateUI(savedInstanceState: Bundle?)

    abstract fun getViewModel(): V

    override fun onCreate(savedInstanceState: Bundle?) {
        performDI()
        performDataBinding()
        super.onCreate(savedInstanceState)
    }

    private fun performDI() =AndroidInjection.inject(this)

    private fun performDataBinding() {
        Log.e("performDataBinding", "1<<<<<<<<")
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        Log.e("performDataBinding", "2<<<<<<<<")
        mViewModel = if(mViewModel == null) getViewModel() else mViewModel
        Log.e("performDataBinding", "3<<<<<<<<")
        binding.setVariable(getBindingVariable(), getViewModel())
        Log.e("performDataBinding", "4<<<<<<<<")
        binding.executePendingBindings()
        Log.e("performDataBinding", "5<<<<<<<<")
    }

}