package com.souptik.maiti.demonationalsystem.remote


import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

object Networking {

    private const val NETWORK_TIME_OUT: Long = 60

    fun create(cacheDir: File, cacheSize: Long, baseUrl: String) : NetworkService {
        val client = OkHttpClient.Builder()
            .cache(Cache(cacheDir, cacheSize))
            .readTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(NETWORK_TIME_OUT, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkService::class.java)
    }
}