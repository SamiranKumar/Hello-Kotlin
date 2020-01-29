package com.samir.learnkotlin

import android.os.Bundle
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //  ButterKnife.bind(this)

        val tvTittle = findViewById<TextView>(R.id.tvTittle)
        tvTittle.text = "HKHR"

        dataType()
        arithmeticOperators()
        inOparator()
    }


    var tittle = "HKHR"
    val numberTest = 2242


    fun dataType() {

        LogPrint.print("tittle:$tittle")
        LogPrint.print("numberTest:$numberTest")

    }


    fun arithmeticOperators() {

        val number1 = 12.5
        val number2 = 3.5

        var result: Double

        result = number1 + number2
        LogPrint.print("number1 + number2 = $result")

        result = number1 - number2
        LogPrint.print("number1 - number2 = $result")

        result = number1 * number2
        LogPrint.print("number1 * number2 = $result")

        result = number1 / number2
        LogPrint.print("number1 / number2 = $result")

        result = number1 % number2
        LogPrint.print("number1 % number2 = $result")
    }





    fun inOparator(){


        print("for (i in 1..5) print(i) = ")
        for (i in 1..5)
            LogPrint.print("$i")


        println()
        print("for (i in 5..1) print(i) = ")
        for (i in 5..1)
            LogPrint.print("$i")

        // prints nothing
        println()
        print("for (i in 5 downTo 1) print(i) = ")
        for (i in 5 downTo 1)
            LogPrint.print("$i")


        println()
        print("for (i in 1..4 step 2) print(i) = ")
        for (i in 1..5 step 2)
            LogPrint.print("$i")

        println()
        print("for (i in 4 downTo 1 step 2) print(i) = ")
        for (i in 5 downTo 1 step 2)
            LogPrint.print("$i")
    }


}
