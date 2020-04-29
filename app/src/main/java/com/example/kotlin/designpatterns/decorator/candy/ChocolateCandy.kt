package com.example.kotlin.designpatterns.decorator.candy

class ChocolateCandy() : Candy() {

    init {
        name = "Chocolate Candy"
    }

    override fun cost(): Double {
        return 2.88
    }
}
