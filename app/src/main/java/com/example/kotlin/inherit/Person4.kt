package com.example.kotlin.inherit

//todo 重写
//在基类中，使用fun声明函数时，此函数默认为final修饰，不能被子类重写。如果允许子类重写该函数，那么就要手动添加 open 修饰它, 子类重写方法使用 override 关键词：
/**用户基类**/
open class Person4 {

    open fun study(){       // 允许子类重写 open
        println("我毕业了")
    }
    open fun study2(){       // 允许子类重写 open
        println("我毕业了")
    }
}