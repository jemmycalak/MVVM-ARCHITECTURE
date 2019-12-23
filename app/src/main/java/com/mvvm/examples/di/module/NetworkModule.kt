package com.mvvm.examples.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mvvm.examples.BuildConfig
import com.mvvm.examples.data.online.API
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGson():Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideLogging():HttpLoggingInterceptor{
        val loging = HttpLoggingInterceptor(object: HttpLoggingInterceptor.Logger{
            override fun log(message: String) {
                Timber.d(message)
            }
        })
        loging.level = HttpLoggingInterceptor.Level.BODY
        return loging
    }

    @Provides
    @Singleton
    fun provideOkHttp(loging:HttpLoggingInterceptor, header:Interceptor):OkHttpClient{
        val okhttp = OkHttpClient.Builder()
        okhttp.addInterceptor(header)
        if(BuildConfig.DEBUG) okhttp.addInterceptor(loging)
        return okhttp.build()
    }

    @Provides
    @Singleton
    fun provideHeader():Interceptor= object :Interceptor{
            override fun intercept(chain: Interceptor.Chain): Response {
                val original = chain.request()
                val builder = original.newBuilder()
                //builder.addHeader("apikey", "apikey")
                //builder.addHeader("Authorization", "authorization")
                return chain.proceed(builder.build())
            }
        }


    @Provides
    @Singleton
    fun provideRetrofit(okhttp:OkHttpClient, gson:Gson):Retrofit=
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASEURL)
            .client(okhttp)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    @Singleton
    fun provideAPI(retrofit: Retrofit):API = retrofit.create(API::class.java)
}