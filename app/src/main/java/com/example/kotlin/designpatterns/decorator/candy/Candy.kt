package com.example.kotlin.designpatterns.decorator.candy

abstract class Candy {

    var name = "unknown candy"

    fun geName(): String {
        return name
    }

    abstract fun cost(): Double
}