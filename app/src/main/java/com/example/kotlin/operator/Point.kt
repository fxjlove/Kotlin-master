package com.example.kotlin.operator

/**
 *
 * 成员函数是指在类或对象中的内部函数
 *
 *  例：声明一个类，在类中在定义一个方法，这个方法就是这个类的成员函数
 */
data class  Point(val x: Int , val y: Int){
    //把运算符声明为一个成员函数
//    operator fun plus(other: Point): Point{
//        return Point(x + other.x,y + other.y)
//    }

//    //把运算符定义为扩展函数
//    operator fun Point.plus(other: Point): Point{
//        return Point(x + other.x,y + other.y)
//    }

}