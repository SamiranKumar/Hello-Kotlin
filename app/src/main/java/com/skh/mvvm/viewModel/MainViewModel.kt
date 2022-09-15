package com.skh.mvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skh.mvvm.model.DataModel


/**
Created by Samiran Kumar on 13,September,2022
 **/
class MainViewModel : ViewModel() {

    // Create the model which contains data for our UI
    private val model = DataModel("Text from MainViewModel!")

    // Create MutableLiveData which MainFragment can subscribe to
    // When this data changes, it triggers the UI to do an update
    val uiTextLiveData = MutableLiveData<String>()


    // Get the updated text from our model and post the value to MainFragment
    fun getUpdatedText() {
        val updatedText = model.textForUI
        uiTextLiveData.postValue(updatedText)
    }

}