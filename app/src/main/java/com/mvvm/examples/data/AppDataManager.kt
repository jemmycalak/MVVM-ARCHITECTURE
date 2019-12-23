package com.mvvm.examples.data

import android.content.Context
import com.mvvm.examples.data.local.pref.PrefListener
import com.mvvm.examples.data.model.RepoModel
import com.mvvm.examples.data.online.ApiManager
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager
@Inject
constructor(val context:Context, val pref:PrefListener, val apiManager: ApiManager) :DataManager, ApiManager{

    override fun isLogin(): Boolean =pref.isLogin()
    override fun setLogin(isLogin: Boolean) = pref.setLogin(isLogin)
    override fun logout() = pref.logout()
    override fun getListRepo(): Single<List<RepoModel>> = apiManager.getListRepo()
}