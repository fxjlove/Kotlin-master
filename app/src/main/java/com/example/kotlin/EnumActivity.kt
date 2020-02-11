package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.kotlin.enump.Color //导入其他包中定义的Color类
import com.example.kotlin.enump.Color.* //显示地导入枚举常量就可以使用他们的名称

/**
 * 枚举 和 "when"
 */
class EnumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)


        var color: Color =Color.BLUE
//
        Log.e("fxj","color1:"+Color.values())
        Log.e("fxj","color2:"+Color.valueOf("RED"))
        Log.e("fxj","color3:"+color.name)
        Log.e("fxj","color4:"+color.ordinal)




        //..语法不仅可以创建数字区间，还可以创建字符区间
        for(i in 1..100){

        }
        for (i in 1 until 100){

        }
        for (i in 'A'..'F'){

        }


        //使用关键字in来迭代区间或者集合
        val list = arrayListOf("10","11","101");
        //迭代集合时使用下标
        for ((index,element) in list.withIndex()){
            Log.e("fxj","$index:$element");
        }

        //使用in来检查区间或者集合是否包含了某个值


    }
    fun getMnemonic(color: Color) = when (color){
            Color.RED -> "Richard"
            Color.BLACK -> "black"
        else -> "other"
    }
    fun getMnemonic2(color: Color){
        when (color){
            Color.RED -> "Richard"
        }
    }
    fun getMnemonic3(color: Color)= when (color){
        Color.RED -> "Richard"
        Color.BLACK -> "BLACK"
        Color.WHITE -> "WHITE"
        Color.GREEN -> "GREEN"
        Color.BLUE -> "BLUE"
    }
    //import com.example.demo2.enump.Color.*
    fun getWarmth(color: Color) = when (color){
        //使用导入的常量名称
            RED,BLACK,WHITE -> "warm"
            GREEN -> "neutral"
            BLUE -> "cold"
    }
    fun getMnu(color: Color) = when(color){
        RED,BLACK,WHITE -> "warm"
        GREEN -> "neutral"
        BLUE -> "cold"
    }

}