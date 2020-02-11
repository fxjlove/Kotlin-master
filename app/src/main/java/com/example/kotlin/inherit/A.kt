package com.example.kotlin.inherit

open class A {
    open fun f () { println("A") }//这个函数是open的：可以在子类中重写它
    fun a() { println("a") }//这个函数是final的：不能在子类中重新它
}