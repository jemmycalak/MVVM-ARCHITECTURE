package com.mvvm.examples.ui.main

import android.util.Log
import com.mvvm.examples.data.DataManager
import com.mvvm.examples.data.model.RepoModel
import com.mvvm.examples.ui.base.BaseViewModel
import com.mvvm.examples.utils.scheduler.SchedulerListener
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class MainModel(dataManager: DataManager, schedulerListener: SchedulerListener)
    : BaseViewModel<MainListener>(dataManager, schedulerListener){

    fun onCreate() {
        compositeDisposable.add(dataManager.getListRepo()
            .subscribeOn(schedulerListener.io())
            .observeOn(schedulerListener.ui())
            .subscribeWith(object :DisposableSingleObserver<List<RepoModel>>(){
                override fun onSuccess(t: List<RepoModel>) {
                    Log.e("Response", t.size.toString())
                }

                override fun onError(e: Throwable) {
                    Log.e("onError", "<<<<<")
                    e.printStackTrace()
                }
            }))
    }
}