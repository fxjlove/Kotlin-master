package com.example.kotlin.designpatterns.decorator.candy

class PeanutCandy() : Candy() {
    init {
        name = "Peanut Candy"
    }

    override fun cost(): Double {
        return 5.55
    }
}