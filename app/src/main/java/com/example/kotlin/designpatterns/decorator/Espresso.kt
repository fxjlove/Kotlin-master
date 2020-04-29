package com.example.kotlin.designpatterns.decorator

/**
 * 意式浓缩咖啡(星巴克)
 *
 */
class Espresso:Beverage() {

    init {
        description = "Espresso"
    }

    override fun cost(): Double {
        return 1.99
    }
}
