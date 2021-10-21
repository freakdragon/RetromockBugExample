package com.example.mvvmkotlinexample.retrofit

import co.infinum.retromock.meta.Mock
import co.infinum.retromock.meta.MockResponse
import com.example.mvvmkotlinexample.model.ServicesSetterGetter
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiTestInterface {

    @Mock
    @MockResponse(body = "services_setter_getter.json")
    @GET("services")
    suspend fun getServices(): Response<ServicesSetterGetter>

}