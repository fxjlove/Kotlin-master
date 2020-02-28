package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.operator.Point

/**
 * 运算符重载及其他约定
 */
class OperatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        println("运算符重载")

        val p1 = Point(10,20)

        val p2 = Point(30,40)
        println(p1+p2)//加号运算符将会转换为plus函数的调用

        /*
            String 接收者类型

            "kotlin" 接收者对象

        */
         println("kotlin".lastChat())

    }

    /**扩展函数**/
    //把运算符定义为扩展函数
    operator fun Point.plus(other: Point): Point{
        return Point(x + other.x,y + other.y)
    }
    /*
        扩展函数
        String 接收者类型
        this 接收者对象

    */

    fun String.lastChat(): Char = this.get(this.length-1)


    //接收者对象可以不用this来访问
    fun String.lastChat2(): Char = get(length-1)



}