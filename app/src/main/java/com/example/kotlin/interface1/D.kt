package com.example.kotlin.interface1

class D : A,B{
    //如果同样的继承成员有不止一个实现，必须提供一个显示的实现
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }

}