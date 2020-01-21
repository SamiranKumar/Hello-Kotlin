package com.samir.learnkotlin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife


class MainActivity : AppCompatActivity() {

    @BindView(R.id.tvTittle)
    lateinit var title: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

       // val tvTittle = findViewById<TextView>(R.id.tvTittle)
        title.text = "HKHR"


    }


}
