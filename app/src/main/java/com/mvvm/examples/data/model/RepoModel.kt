package com.mvvm.examples.data.model

import com.google.gson.annotations.SerializedName

data class RepoModel(val id:Long, val name:String, val description:String, val owner:UserModel,
                     @field:SerializedName("stargazers_count") val stars:Long,
                     @field:SerializedName("forks_count") val forks: Long)
data class UserModel(val login:String)