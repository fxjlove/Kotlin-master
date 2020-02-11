package com.example.kotlin.interface1

interface A {
    fun foo2() = println("foo2")
    fun foo() { print("A") }   // 已实现                     带默认实现的方法
    fun bar()                  // 未实现，没有方法体，是抽象的  普通的方法声明
}