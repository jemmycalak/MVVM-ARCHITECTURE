package com.mvvm.examples.data.online

import com.mvvm.examples.data.model.RepoModel
import io.reactivex.Single

interface ApiManager {
    fun getListRepo():Single<List<RepoModel>>
}