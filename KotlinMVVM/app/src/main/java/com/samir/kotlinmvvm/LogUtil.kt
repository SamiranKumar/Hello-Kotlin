package com.samir.kotlinmvvm

import com.samir.kotlinmvvm.BuildConfig
import timber.log.Timber

class LogUtil{
   open fun initializeLog(tagName: String) {
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                 override fun createStackElementTag(element: StackTraceElement): String? {
                    return tagName + ":[" + super.createStackElementTag(element) + ":" + element.lineNumber + "]"
                }
            })
        } else { //
        }
    }
}