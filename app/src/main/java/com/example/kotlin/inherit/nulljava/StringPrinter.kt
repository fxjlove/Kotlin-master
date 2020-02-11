package com.example.kotlin.inherit.nulljava

/**
 * 实现Java接口时使用不同的参数可空性
 */
class StringPrinter : StringProcessor{
    override fun process(value: String) {
        println(value)
    }
}