package com.example.mvvmkotlinexample.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmkotlinexample.model.ServicesSetterGetter
import com.example.mvvmkotlinexample.retrofit.RetrofitClient
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.util.*

object MainActivityRepository {

    val serviceSetterGetter = MutableLiveData<ServicesSetterGetter>()

    private var job: Job? = null

//    var servicesLiveData = MutableLiveData<ServicesSetterGetter>()


    fun getServicesApiCall(onSuccess: (ServicesSetterGetter) -> Unit, onFailure: (Exception) -> Unit) {

//        val call = RetrofitClient.apiInterface.getServices()


        runCatching { job?.cancel() }

        job = CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.apiTestInterface.getServices()

                withContext(Dispatchers.Main) {
                    onSuccess(response.body()!!)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    onFailure(e)
                }
            }
        }

//        val call = RetrofitClient.apiInterface.getServices()
//
//        call.enqueue(object: Callback<ServicesSetterGetter> {
//            override fun onFailure(call: Call<ServicesSetterGetter>, t: Throwable) {
//                // TODO("Not yet implemented")
//                Log.v("DEBUG : ", t.message.toString())
//            }
//
//            override fun onResponse(
//                call: Call<ServicesSetterGetter>,
//                response: Response<ServicesSetterGetter>
//            ) {
//                // TODO("Not yet implemented")
//                Log.v("DEBUG : ", response.body().toString())
//
//                val data = response.body()
//
//                val msg = data!!.message
//
//                serviceSetterGetter.value = ServicesSetterGetter(msg)
//            }
//        })
//
//        return serviceSetterGetter
    }
}