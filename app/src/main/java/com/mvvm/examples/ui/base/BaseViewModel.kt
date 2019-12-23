package com.mvvm.examples.ui.base

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.mvvm.examples.data.DataManager
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

abstract class BaseViewModel<N>(val dataManager: DataManager): ViewModel() {

    var mNavigator:WeakReference<N>?=null
    val isLoading = ObservableBoolean()
    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun setNavigator(nav:N){
        Log.e("setNav", "<<<<<<<")
        mNavigator = WeakReference(nav)
    }

    fun navigate():N = mNavigator!!.get()!!

    fun setIsLoading(isLoad:Boolean){
        isLoading.set(isLoad)
    }


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}