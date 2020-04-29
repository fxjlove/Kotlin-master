package com.example.kotlin.designpatterns.decorator.candy

abstract class CandyDecorate : Candy() {
    abstract fun getCandyName(): String
}
