package com.example.androidauto.network

import com.example.androidauto.BuildConfig
import com.example.androidauto.network.model.IdfElevators
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IDFElevatorsAPI {

    @GET("idf_elevators")
    fun listElevators() : Deferred<IdfElevators>

    companion object Factory {
        @Volatile
        private var retrofit: Retrofit? = null

        @Synchronized
        fun getInstance(): IDFElevatorsAPI {
            retrofit = retrofit
                ?: buildRetrofit()
            return retrofit!!.create(
                IDFElevatorsAPI::class.java)
        }

        private fun buildRetrofit() = Retrofit.Builder()
            .baseUrl("https://api.formation-android.fr/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client())
            .build()

        private fun client() = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
            .build()
    }

}