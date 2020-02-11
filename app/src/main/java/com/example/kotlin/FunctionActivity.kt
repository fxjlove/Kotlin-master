package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
//import 包名.函数名来导入我们将要使用的函数
import com.example.kotlin.function.joinToString

/**
 * 函数、高阶函数
 */
class FunctionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        //joinToString函数：通过在元素中间添加分隔符号，在最钱买呢添加前缀，在最末尾添加后缀的方式把集合的元素阻隔添加到StringBuilder的过程


        //调用顶层函数
        //使用方法，就跟调用 Java 静态方法一样，类名.方法名，例如 StringFunctions.str()
        val str: String = joinToString()
        Log.e("fxj","$str")





        //调用
        //当入参有歧义发生时,如不能明确指明传入的参数是哪个变量,需要显式声明入参,如下面调用
        sum3(two=3)




        //可变数量参数:
        //普通调用方法
        sum(1,2,3,4,5,6)
        //扩展运算符*调用
        val intArrayOf = intArrayOf(1, 2, 3, 4, 5, 6)
        sum(*intArrayOf)




        //函数作为参数传入:
        //调用方式一
        sum4(1,2,{one,another->one + another})
        //调用方式二
        sum4(1,2,::sum5)








        //匿名函数:

        //普通函数定义
        toUpper("helloword",fun(str:String) = str.toUpperCase())

        //匿名函数 调用,it指代调用者
        "helloword".toUpper2 { it.toUpperCase() }


    }
    //1.对于方法体只有单个表达式的,可以省略大括号,如下:
    //普通写法
    fun sum(one:Int,another:Int):Int{
        return one+another
    }
    //高阶写法
    fun sum2(one:Int,another:Int):Int = one+another







    //函数的入参可以有默认值,对于没有默认值的参数需要传入,有默认值的参数可以省略传参;
    //当入参有歧义发生时,如不能明确指明传入的参数是哪个变量,需要显式声明入参,如下面调用
    fun sum3(one:Int=1,two:Int,three:Int=3):Int = one + two + three






    //可变数量参数,
    //定义方法
    fun sum(vararg nums:Int):Int{
        var sum = 0
        for (one in nums){
            sum += one
        }
        return sum
    }







    //定义函数
    fun sum4(one:Int,two:Int,body:(Int,Int)->Int):Int = body(one,two)

    fun sum5(one:Int=1,another:Int=2):Int{
        return one+another
    }





    //ambda表达式定义函数
    //完整定义
    var sum6 : (Int,Int) -> Int = {x : Int, y : Int -> x + y}

    //省略函数参数类型约束
    var sum7 = {x : Int, y : Int -> x + y}

    var sum8 :(Int,Int) -> Int = {x , y -> x + y}





    //匿名函数
    //1.普通函数定义
    fun toUpper(str:String,body:(String)->String):String = body(str)

    //2.匿名函数定义,this指代调用者
    fun String.toUpper2(body:(String)->String):String = body(this)


}