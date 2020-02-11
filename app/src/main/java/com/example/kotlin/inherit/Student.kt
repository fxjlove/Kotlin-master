package com.example.kotlin.inherit

//子类有主构造函数
//如果子类有主构造函数， 则基类必须在主构造函数中立即初始化。
class Student(name : String, age : Int, var no : String, var score : Int) : Person(name,age) {
}