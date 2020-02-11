package com.example.kotlin.inherit

//"val"意味着想要的属性会用构造方法的参数来初始化

//带2个参数的主构造方法
class User(val nickname: String,
           val inSubscribed: Boolean = true) {
    //为构造方法参数提供一个默认值 val inSubscribed: Boolean = true

    //初始化语句块
    init {
        //
    }
}