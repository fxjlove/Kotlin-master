package com.example.kotlin.designpatterns.decorator.candy

class RedBox(var candy: Candy) : CandyDecorate() {
    override fun getCandyName(): String {
        return candy.name + " with red box"
    }

    override fun cost(): Double {
        return candy.cost() + 1.55
    }
}
