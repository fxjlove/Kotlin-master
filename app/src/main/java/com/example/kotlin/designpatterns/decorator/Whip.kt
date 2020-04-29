package com.example.kotlin.designpatterns.decorator

//奶油
class Whip(var beverage: Beverage):CondimentDecorator() {
    override fun getDescriptions(): String {
        return "${beverage.getDescriptions()},Whip"
    }

    override fun cost(): Double {
        return 0.10+beverage.cost()
    }
}
