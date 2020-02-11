package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * 类型系统
 */
class BaseTypeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)


        baseType()

        collection()

    }
    //todo 基本数据类型和其他基本类型
    fun baseType() {
        println("基本数据类型和其他基本类型～～～～～～～～～～～～～")
        /*
            1. Any 和 Any?  :根类型

            Any类型是Kotlin所有非空类型的超类型（非空类型的根）
        */

        val answer: Any = 42//Any是引用类型，所以值42会被装箱
    }
    //todo Kotlin集合和Java
    fun collection(){
        println("Kotlin集合和Java～～～～～～～～～～～～～")
        /*

            Iterable Collection List Set  只读接口

            MutableInterable  MutableCollection MutabaeList  MutableSet  可变接口


            ArrayList HashSet Java类



            集合类型     只读             可变

            List        listOf       mutalbeListOf arrayListOf

            Set         setOf        mutalbeSetOf  hashSetOf  linkedSetOf  sortedSetOf

            Map         mapOf        mutalbeMapOf  hashMapOf  linkedMapOf  sortedMapOf



        */
    }

}