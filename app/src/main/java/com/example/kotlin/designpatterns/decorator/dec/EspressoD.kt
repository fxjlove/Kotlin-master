package com.example.kotlin.designpatterns.decorator.dec

/**
 * 意式浓缩咖啡(星巴克)
 *
 */
class EspressoD:BeverageD() {

    init {
        description = "Espresso"
    }

    override fun cost(): Double {
        return 1.99
    }
}
