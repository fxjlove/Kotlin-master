package com.example.kotlin.designpatterns.decorator

//将摩卡、蒸奶等调料建立类继承自CondimentDecrator：(注意在cost方法中要加上咖啡的价格，描述时也要加上咖啡的名称)
//摩卡
class Mocha(var beverage: Beverage):CondimentDecorator() {
    override fun getDescriptions(): String {
        return "${beverage.getDescriptions()},Mocha"
    }

    override fun cost(): Double {
        return 0.20+beverage.cost()
    }
}
