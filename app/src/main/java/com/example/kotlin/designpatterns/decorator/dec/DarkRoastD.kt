package com.example.kotlin.designpatterns.decorator.dec

/**
 * 深度烘焙咖啡(星巴克)
 *
 */
class DarkRoastD:BeverageD() {

    init {
        description = "DarkRoast"
    }

    override fun cost(): Double {
        return 2.99
    }
}
