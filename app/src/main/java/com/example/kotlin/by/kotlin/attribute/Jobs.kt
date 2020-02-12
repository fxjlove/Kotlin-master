package com.example.kotlin.by.kotlin.attribute

import kotlin.reflect.KProperty

/**
 * 定义一个委托类Jobs，
 * 为属性name创建了operator修饰的getValue和setValue方法
 * 该属性可被其他了委托该类共享
 */
class Jobs {
    var name: String = "工作名"
    operator fun setValue(thisRef: SoftWareDev, property: KProperty<*>, value: String) {
        this.name = value
    }

    operator fun getValue(thisRef: SoftWareDev, property: KProperty<*>): String {
        return this.name
    }
}