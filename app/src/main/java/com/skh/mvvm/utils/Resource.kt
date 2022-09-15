package com.skh.mvvm.utils


/**
Created by Samiran Kumar on 06,September,2022
 **/
data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object{

    }
}
