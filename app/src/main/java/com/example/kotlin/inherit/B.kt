package com.example.kotlin.inherit

interface B {
    fun f() { println("B") } //接口的成员变量默认是 open 的
    fun b() { println("b") }
}