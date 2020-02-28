package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import com.example.kotlin.applybean.Resp
import com.example.kotlin.applybean.User
import com.example.kotlin.applybean.User2
import com.example.kotlin.applybean.User3
import kotlinx.android.synthetic.main.activity_apply.*
import org.jetbrains.anko.toast
import java.lang.Exception
import java.util.*

/**
 * Kotlin异常处理 捕获异常
 *   try-catch 语句
 *   try-catch 表达式
 *   多 catch 代码块
 *   try-catch 语句嵌套
 */
class TryCatchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)
/*

        在Kotlin中，所有异常类都是Throwable类的子类。 要抛出异常对象，Kotlin使用throw表达式  throw MyException("this throws an exception")


        try：try块包含可能生成异常的语句集。必须后跟catch 或 finally或两者。
        catch：catch块用于捕获try块抛出的异常。
        finally：finally块始终执行是否处理异常。所以它用于执行重要的代码语句。
        throw：throw关键字用于显式抛出异常。


        Kotlin finally是这样的块：无论是否处理异常，它总是执行。 所以它用于执行重要的代码语句。
        Kotlin throw关键字用于抛出显式异常。它用于抛出自定义异常。要抛出异常对象，将使用throw-expression。


*/

        test3()


    }
    private fun test1(){

        var value = "11111%"
        //一、try-catch 语句
        try {
            // 可能会发生异常的代码
            var result = value.toInt()
        } catch (throwable: Throwable) {
            // 捕获到异常的处理
            throwable.printStackTrace()
        }

        try {
            var result = value.toInt()
        } catch (e: Exception) {
            e.printStackTrace()
        }


        //没有异常处理的问题
//        val data = 20 / 0   //may throw exception
        try {
            val data = 20 / 0  //may throw exception
        } catch (e: ArithmeticException) {
            Log.e("fxj", e.toString())
        }


        Log.e("fxj", "code below exception ...")

    }

    private fun test2(){
        //Kotlin try块作为表达式
//        val str = getNumber("10")
        val str = getNumber2("10.5")
//        Log.e("fxj", str.toString())


        //Kotlin多个catch块示例1
        try {
            val a = IntArray(5)
            a[5] = 10 / 0
        } catch (e: ArithmeticException) {
            println("arithmetic exception catch")
        } catch (e: ArrayIndexOutOfBoundsException) {
            println("array index outofbounds exception")
        } catch (e: Exception) {
            println("parent exception class")
        }
        println("code after try catch...")
        //一次只发生一个异常，并且一次只执行一个catch块。
        //规则： 所有catch块必须从最具体到一般放置，即ArithmeticException的catch必须在Exception的catch之前。

        println("``````````````````````````````````")

        try {
            val a = IntArray(5)
            a[5] = 10 / 0
        }
        catch (e: Exception) {
            println("parent exception catch")
        }
        catch (e: ArithmeticException) {
            println("arithmetic exception catch")
        } catch (e: ArrayIndexOutOfBoundsException) {
            println("array index outofbounds exception")
        }

        println("code after try catch...")


    }


    private fun getNumber(str: String): Int {
        return try {
            Integer.parseInt(str)
        } catch (e: ArithmeticException) {
            0
        }
    }
    private fun getNumber2(str: String): Int {
        return try {
            Integer.parseInt(str)
        } catch (e: NumberFormatException) {
            0
        }
    }
    //todo Kotlin throw关键字
    private fun test3() {
        //Kotlin throw关键字用于抛出显式异常。它用于抛出自定义异常。要抛出异常对象，将使用throw-expression。

        //throw关键字的语法
//        throw SomeException()
        validate(15)
        println("code after validation check...")


    }
    fun validate(age: Int) {
        if (age < 18)
            throw ArithmeticException("under age")
        else
            println("eligible for drive")
    }


    /**
     * String与Int之间的转换
     */
    private fun stringToInt(){
        // 定义一个整形变量
        var number1 = 12345

        // 定义一个字符串变量
        var string1 = "9876"

        // Int整形 转> String字符串
        string1 = number1.toString()
        println("string1:$string1")

        // String字符串  转>  Int整形
        number1 = string1.toInt()
        println("number1:$number1")


        // ----------------------------
        println("-------------------------")


        // 定义一个整形变量
        var numberA1: Int = 999999

        // 定义一个字符串变量
        var stringA1: String = "888888"

        // Int整形 转> String字符串
        stringA1 = "070797".toString()
        println("stringA1:$stringA1")

        // String字符串  转>  Int整形
        numberA1 = 161616166.toInt()
        println("numberA1:$numberA1")
    }
}




