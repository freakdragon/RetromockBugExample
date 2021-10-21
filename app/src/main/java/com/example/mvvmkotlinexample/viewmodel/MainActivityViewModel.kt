package com.example.mvvmkotlinexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmkotlinexample.model.ServicesSetterGetter
import com.example.mvvmkotlinexample.repository.MainActivityRepository

class MainActivityViewModel : ViewModel() {

    var servicesLiveData = MutableLiveData<ServicesSetterGetter>()

    fun getUser() {
        MainActivityRepository.getServicesApiCall(
            onSuccess = {

            },
            onFailure = {

            }
        )
    }

}