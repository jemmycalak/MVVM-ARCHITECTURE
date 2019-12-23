package com.mvvm.examples.data.online

import com.mvvm.examples.data.model.RepoModel
import io.reactivex.Single
import retrofit2.http.GET

interface API {

    @GET("org/Google/repos")
    fun getListRepo():Single<List<RepoModel>>
}