package com.skh.mvvm.network.repository

import com.skh.mvvm.model.ResponsePost
import com.skh.mvvm.network.ApiServicesImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


/**
Created by Samiran Kumar on 20,September,2022
 **/
class MainRepository @Inject constructor(private val apiServicesImp: ApiServicesImp) {

    fun getPost(): Flow<List<ResponsePost>> = flow {
        emit(apiServicesImp.getPost())
    }.flowOn(Dispatchers.IO)
}