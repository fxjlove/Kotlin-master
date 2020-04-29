package com.example.kotlin.designpatterns.decorator.candy

class MilkCandy() : Candy() {

    init {
        name = "Milk Candy"
    }

    override fun cost(): Double {
        return 3.88
    }

}