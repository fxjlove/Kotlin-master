package com.example.kotlin.designpatterns.decorator

/**
 * 深度烘焙咖啡(星巴克)
 *
 */
class DarkRoast:Beverage() {

    init {
        description = "DarkRoast"
    }

    override fun cost(): Double {
        return 2.99
    }
}
