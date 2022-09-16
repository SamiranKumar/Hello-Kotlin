package com.skh.mvvm.network

import com.skh.mvvm.model.ResponsePost


/**
Created by Samiran Kumar on 20,September,2022
 **/
sealed class ApiState {
    object Loading : ApiState()
    class Failure(val throwable: Throwable) : ApiState()
    class Success(val data: List<ResponsePost>) : ApiState()
    object Empty : ApiState()
}
