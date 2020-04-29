package com.example.kotlin.designpatterns.decorator

//咖啡的基类：
abstract class Beverage(var description: String = "Unknown Beverage") {

    /*open         可以被重写
    abstract        必须被重写*/
    //描述
    open fun getDescriptions():String{
        return description
    }

    //价钱
    abstract fun cost():Double

}
