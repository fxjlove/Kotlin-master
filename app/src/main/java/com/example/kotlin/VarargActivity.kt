package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
//import 包名.函数名来导入我们将要使用的函数

/**
 * 具名参数&可变参数
 */
class VarargActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        //具名参数
        //给函数的实参附上形参
        sum(arg1 = 1, arg2 = 2)


        //变长参数:  vararg 关键字，参数长度可变化
        hello(1,2,3,4,5)

        //如果传参数时有歧义，则需要使用具名参数 (当变长参数前面有参数时，如果编译器能识别出来可以不用具名参数传入了，如果在其后面有参数时，则要使用具名参数指定类型传入了)
        hello2(1.0, 1, 2, 3, 4, 5, string = "hello")
//        double 编译器可以识别出来类型
//        string 编译器提示使用具名参数传入



        /*
        Spread Operator
        只支持展开Array
        只用于变长参数列表的实参
        不能重载
        */
        val array = intArrayOf(1, 2, 3, 4, 5)
        hello2(3.0, *array, string = "hello")
        //array 前面加 *


        println("····································")

        //传参时，如果有歧义，需要使用具名参数
        world(ints = *intArrayOf(1, 2, 3, 4, 5), string = "world")
        //第一个参数指定的默认参数，调用时可以省略不传



        world2(3.0, *array)
        //如果默认参数在最后一个，不会产生歧义
    }
    fun sum(arg1: Int, arg2: Int) = arg1 + arg2


    //某个参数可以接受多个值
    fun hello(vararg ints: Int) {
        ints.forEach(::println)
    }

    fun hello2(double: Double, vararg ints: Int, string: String) {
        println(double)
        println("`------------------------")
        ints.forEach(::println)
        println("`------------------------")
        println(string)
    }
/*
    默认参数

    为函数参数指定默认值

    可以为任意位置的参数指定默认值

    传参时，如果有歧义，需要使用具名参数*/
    fun world(double: Double = 3.0, vararg ints: Int, string: String) {
        println(double)
        ints.forEach(::println)
        println(string)
    }

    fun world2(double: Double, vararg ints: Int, string: String = "world"){

    }



}