package com.example.kotlin.designpatterns.decorator

abstract class CondimentDecorator:Beverage() {

    abstract override fun getDescriptions():String

}