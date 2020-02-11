package com.example.kotlin.interface1

//这个类是抽象的：不能创建它的实例
abstract class Animated {
    //这个函数是抽象的：它没有实现必须被子类重写
    abstract fun animate()


    //抽象类中的非抽象函数并不是默认open的，但是可以标注为open的

    open fun stopAnimating(){

    }
    fun animateTwice(){

    }
}