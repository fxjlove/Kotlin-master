package com.example.kotlin.designpatterns.decorator.candy

class BlueBox(var candy: Candy) : CandyDecorate() {

    override fun getCandyName(): String {
        return candy.name + " with blue box"
    }

    override fun cost(): Double {
        return candy.cost() + 1.88
    }

}