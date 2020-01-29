package com.samir.learnkotlin

import android.util.Log

interface LogPrint {

    companion object {

        fun print(message: String) {
            Log.i("SKH", message)
        }
    }
}