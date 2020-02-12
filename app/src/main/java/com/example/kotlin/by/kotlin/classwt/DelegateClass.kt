package com.example.kotlin.by.kotlin.classwt

/**
 * 定义一个委托类，实现了Creature接口
 */
class DelegateClass : Creature {
    override val type: String
        get() = "委托类该属性"

    override fun run() {
        println("代理类执行run方法")
    }
}