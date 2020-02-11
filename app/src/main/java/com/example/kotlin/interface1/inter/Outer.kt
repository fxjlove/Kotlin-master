package com.example.kotlin.interface1.inter

/**
 * 嵌套类不持有外部类的引用，而内部类持有
 *
 *  内部类持有一个外部类的引用的话需要使用inner修饰符
 */
class Outer {
    //在Kotlin中引用外部类实例的语法也与Java不同，需要使用this@Outer从Inner类去访问Outer类
   inner class Inner{

        fun getOuterReference(): Outer = this@Outer
    }
}