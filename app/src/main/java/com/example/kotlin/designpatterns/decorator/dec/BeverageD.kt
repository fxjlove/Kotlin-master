package com.example.kotlin.designpatterns.decorator.dec

//咖啡的基类：
abstract class BeverageD(var description: String = "Unknown Beverage") {

    //描述
    open fun getDescriptions():String{
        return description
    }

    //价钱
    abstract fun cost():Double

}
