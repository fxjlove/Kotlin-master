package com.example.kotlin.inherit

/**用户基类**/
open class Person2(name:String) {

    /**次级构造函数**/
    constructor(name:String,age:Int):this(name){
        //初始化
        println("-------基类次级构造函数---------")
    }

}