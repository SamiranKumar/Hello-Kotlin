package com.samir.kotlinmvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.samir.kotlinmvvm.BuildConfig
import com.samir.kotlinmvvm.R
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tagName: String = "SKHLOG"

        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement): String? {
                    return tagName + ":[" + super.createStackElementTag(element) + ":" + element.lineNumber + "]"
                }
            })
        } else { //
        }
        Timber.d("MainActivity")
        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_container, ProductListFragment()).commit()
    }
}
