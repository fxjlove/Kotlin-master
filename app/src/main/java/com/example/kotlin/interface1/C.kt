package com.example.kotlin.interface1

class C : A{
    //C 是一个实现了 A 的具体类，所以必须要重写 bar() 并实现这个抽象方法。
    override fun bar() {// 重写
        print("bar")
    }
}