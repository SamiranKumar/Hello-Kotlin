package com.skh.mvvm.network

import com.skh.mvvm.model.ResponsePost
import retrofit2.http.GET


/**
Created by Samiran Kumar on 15,September,2022
 **/
interface ApiServices {

    @GET("posts")
    suspend fun getPost(): List<ResponsePost>

}