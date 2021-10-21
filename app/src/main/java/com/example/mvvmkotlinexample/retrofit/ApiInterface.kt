package com.example.mvvmkotlinexample.retrofit

import com.example.mvvmkotlinexample.model.ServicesSetterGetter
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

//    @GET("services")
//    fun getServices() : Call<ServicesSetterGetter>
    @GET("services")
    suspend fun getServices(): Response<ServicesSetterGetter>

}