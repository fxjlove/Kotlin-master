package com.example.kotlin.inherit.nulljava

/**
 * 实现Java接口时使用不同的参数可空性
 */
class NullableStringPrinter : StringProcessor{
    override fun process(value: String?) {
        if (value != null){
            println(value)
        }

    }
}