package com.example.mvvmkotlinexample.retrofit

import co.infinum.retromock.Retromock
import com.example.mvvmkotlinexample.BuildConfig
import com.example.mvvmkotlinexample.utils.ResourceBodyFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitClient {

    const val MainServer = "http://api.drfriday.in/api/user/"
    
    const val ImageMainServer = "http://api.drfriday.in/";

    val retrofitClient: Retrofit.Builder by lazy {

        val levelType: Level
        if (BuildConfig.BUILD_TYPE.contentEquals("debug"))
            levelType = Level.BODY else levelType = Level.NONE

        val logging = HttpLoggingInterceptor()
        logging.setLevel(levelType)

        val okhttpClient = OkHttpClient.Builder()
        okhttpClient.addInterceptor(logging)


        Retrofit.Builder()
            .baseUrl(MainServer)
            .client(okhttpClient.build())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val retromockClient by lazy {
        Retromock.Builder()
            .retrofit(retrofitClient.build())
            .defaultBodyFactory(ResourceBodyFactory())
    }

    val apiTestInterface: ApiTestInterface by lazy {
        retromockClient
            .build()
            .create(ApiTestInterface::class.java)
    }

    val apiInterface: ApiInterface by lazy {
        retrofitClient
            .build()
            .create(ApiInterface::class.java)
    }
}
