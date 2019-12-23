package com.mvvm.examples.data.online

import com.mvvm.examples.data.model.RepoModel
import io.reactivex.Single
import javax.inject.Inject

class Presenter @Inject constructor(val api:API) : ApiManager {

    override fun getListRepo():Single<List<RepoModel>> = api.getListRepo()
}