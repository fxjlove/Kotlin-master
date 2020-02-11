package com.example.kotlin.inherit

//子类没有主构造函数
//如果子类没有主构造函数，则必须在每一个二级构造函数中用 super 关键字初始化基类，或者在代理另一个构造函数。初始化基类时，可以调用基类的不同构造方法。

class Student4 : Person4() {

    //这个函数重写了一个open函数并且它本身同样是open的
    override fun study() { // 重写方法 override
        println("我在读大学")
    }
    //在这里"final"并没有被删减是因为没有"final"的 "override"意味着是open的
   final override fun study2() { // 重写方法 override
        println("我在读大学2")
    }
}