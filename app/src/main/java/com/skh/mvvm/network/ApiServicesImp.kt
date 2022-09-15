package com.skh.mvvm.network

import com.skh.mvvm.model.ResponsePost
import javax.inject.Inject


/**
Created by Samiran Kumar on 15,September,2022
 **/
class ApiServicesImp @Inject constructor(private val apiServices: ApiServices) {
    suspend fun getPost(): List<ResponsePost> = apiServices.getPost()
}