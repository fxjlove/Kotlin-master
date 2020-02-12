package com.example.kotlin.by.kotlin


//类委托

// 通过关键字 by 建立委托类
class Derived(b: Base) : Base by b
//
//fun main(args: Array<String>) {
//    val b = BaseImpl(10)
//    Derived(b).print() // 输出 10
//}