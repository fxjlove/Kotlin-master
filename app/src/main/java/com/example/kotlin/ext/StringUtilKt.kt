package com.example.kotlin.ext

import android.content.Context
import java.lang.StringBuilder

//声明一个扩展函数
fun String.lastChat(): Char = this.get(this.length-1)

//声明一个扩展属性
val String.lastChar2: Char get() = get(this.length - 1)

//声明一个可变的扩展属性
var StringBuilder.lastChar3: Char
    //get属性
    get() = get(length - 1)
    //set属性
    set(value) {
        this.setCharAt(length - 1, value)
    }


fun Context.getAppVersion(): String{
    return ""
}



fun processTheAnswer(f: (Int) -> Int){
    println(f(42))
}