package com.example.kotlin.interface1

/**
 * Kotlin 接口
 *
 *   Kotlin 接口与 Java 8 类似，使用 interface 关键字定义接口，允许方法有默认实现：
 */
interface MyInterface2 {
    //接口中的属性只能是抽象的，不允许初始化值，接口不会保存属性值，实现接口时，必须重写属性：
    var name:String //name 属性, 抽象的


}