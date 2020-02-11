package com.example.kotlin.inherit.class1

/**
 * 数据类
Kotlin 可以创建一个只包含数据的类，关键字为 data：

equals() / hashCode()
toString() 格式如 "User(name=John, age=42)"
componentN() functions 对应于属性，按声明顺序排列
copy() 函数

 */
data class User2(val name: String, val age: Int) {

}