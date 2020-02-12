package com.example.kotlin.by.kotlin.classwt

//①委托类作为构造器形参传入（常用）
/**
 * 定义一个Human类，实现了Creature接口，委托类作为形参传入，由形参委托类对象作为委托对象
 */
class Human(delegateClass: DelegateClass) : Creature by delegateClass