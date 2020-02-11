package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.kotlin.bean.Person
import com.example.kotlin.bean.Rectangle
import com.example.kotlin.bean.createRandomRectangle

/**
 * 类和属性
 */
class ClassesAndPropertiesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)


        val person = Person("Bob",true)
        person.isMarried = false

        Log.e("fxj",person.name +"//"+ person.isMarried)


        val rectange = Rectangle(41,41)

        Log.e("fxj","isSquare:"+rectange.isSquare +"//" + rectange.isSquare2 +"//"+ createRandomRectangle().isSquare)

        //Kotlin还可以直接导入函数，导入后可直接使用对应的函数
       var isSquare:Boolean =  createRandomRectangle().isSquare

        //Kotlin同样可以在包名称后加上.*来导入特定包中定义的所有声明，包括类、函数以及属性。
    }

}