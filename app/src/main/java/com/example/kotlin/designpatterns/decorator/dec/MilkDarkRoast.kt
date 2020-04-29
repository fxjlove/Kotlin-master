package com.example.kotlin.designpatterns.decorator.dec

//DarkRoast加牛奶
class MilkDarkRoast: BeverageD() {

    init {
        description = "MilkDarkRoast"
    }

    override fun cost(): Double {
        return 3.0
    }
}