package com.example.kotlin.inherit

class C():A(),B {
    override fun f() {
        super<A>.f()//调用 A.f()
        super<B>.f()//调用 B.f()
    }
}