package com.example.kotlin.by.kotlin.classwt

//③新建委托类对象，并自己实现方法/属性
/**
 * 定义一个pig类，实现了Creature接口，新建一个委托类作为委托对象，并自己实现了抽象方法
 */
class Pig : Creature by DelegateClass() {
    override fun run() {
        println("自己执行实现的run方法")
    }

    override val type: String
        get() = "自己实现的type属性"
}