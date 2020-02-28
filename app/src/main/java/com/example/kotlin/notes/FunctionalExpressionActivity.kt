package com.example.kotlin.notes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.R

//导入扩展函数
//import com.example.demo2.util.lastChat

//import com.example.demo2.ext.lastChar3
//import java.lang.StringBuilder

//可以使用关键字as来修改导入的类或者函数名称

/**
 * 函数表达式
 */
class FunctionalExpressionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        println(addMethod1(1, 1))
        println(addMethod2(2, 2))

        /**
         * 函数第三种写法
         */
        var addMethod3 = {number1: Int, number2: Int -> number1 + number2}
        // 注意：addMethod3看起来是一个变量，实际上是方法 addMethod3(3, 3)
        println(addMethod3(3, 3))

        /**
         * 函数第四种写法
         * addMethod4 : (参数的类型) -> 返回的类型 = {参数变量名 -> 返回值}
         * addMethod4 : (Int, Int) -> Int = { number1, number2 -> number1 + number2 }
         */
        var addMethod4 : (Int, Int) -> Int = { number1, number2 -> number1 + number2 }
        // 注意：addMethod4看起来是一个变量，实际上是方法 addMethod4(4, 4)
        println(addMethod4(4, 4))
    }

    /**
     * 函数第一种写法
     */
    fun addMethod1(number1: Int, number2: Int) : Int {
        return number1 + number2
    }

    /**
     * 函数第二个种写法
     */
    fun addMethod2(number1: Int, number2: Int) = number1 + number2



}
