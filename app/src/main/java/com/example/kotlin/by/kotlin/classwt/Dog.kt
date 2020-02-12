package com.example.kotlin.by.kotlin.classwt

//②新建委托类对象
/**
 * 定义一个Dog类，实现了Creature接口，新建一个委托类作为委托对象
 */
class Dog : Creature by DelegateClass()