package com.example.kotlin.interface1

//一个类或者对象可以实现一个或多个接口。
class Child:MyInterface {
    override fun bar() {
        println("bar")
    }
}