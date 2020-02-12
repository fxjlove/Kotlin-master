package com.example.kotlin.by.kotlin

// 实现此接口的被委托的类
class BaseImpl(val x: Int) : Base {
    override fun print() {
        println(x)
    }
}