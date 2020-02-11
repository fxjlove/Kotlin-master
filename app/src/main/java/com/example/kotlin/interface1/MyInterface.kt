package com.example.kotlin.interface1

/**
 * Kotlin 接口
 *
 *   Kotlin 接口与 Java 8 类似，使用 interface 关键字定义接口，允许方法有默认实现：
 */
interface MyInterface {

    fun bar()    // 未实现
    fun foo() {  //已实现
        // 可选的方法体
        println("foo")
    }
}