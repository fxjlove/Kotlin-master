package com.example.kotlin.notes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.R
/**
 * Kotlin 标签@使用
 */
class LabelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)

/*
        标签定义

        在 Kotlin 中任何表达式都可以用标签（label）来标记。 标签的格式为标识符后跟 @ 符号，例如：abc@、fooBar@都是有效的标签（参见语法）。 要为一个表达式加标签，我们只要在其前加标签即可。
   */


//        foo()
        test()
    }

    //TODO 标签处返回
    fun foo() {
        //Kotlin 有函数字面量、局部函数和对象表达式。因此 Kotlin 的函数可以被嵌套。 标签限制的 return 允许我们从外层函数返回。 最重要的一个用途就是从 lambda 表达式中返回。
        listOf(1, 2, 3, 4, 5).forEach lit@{
            if (it == 3) return@lit // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
            println(it)
        }
        println("~~~~~~~~~~~ 使用隐式标签")

        println(" done with implicit label")
        //现在，它只会从 lambda 表达式中返回。通常情况下使用隐式标签更方便。 该标签与接受该 lambda 的函数同名。
        //所谓的隐式标签就是该标签与接收该lambda的函数同名。

        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@forEach // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
            println(it)
        }
        println(" done with implicit label")

        println("~~~~~~~~~~~ 不使用标签")
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return
            println(it)
        }




    }
    //Return返回最外层函数
    private fun test(){
        //一个不带标签的 return 语句 总是在用 fun 关键字声明的函数中返回。

        println("测试函数参数是由fun定义")
        fooc()


        println("测试函数参数是由Lamdb定义")
        fooc1()
    }

    private fun fooc() {
        listOf(1, 2, 3).forEach(fun(item: Int) {
            if (item == 2) return // 局部返回到匿名函数的调用者，即 forEach 循环
            println("当前遍历的值是 $item")
        })
        println("list集合遍历完成")


    }

    /**
     *  传入作为的参数的函数
     */
    private fun fooc1() {
        listOf<Int>(1, 2, 3).map { item ->
            if (item == 2) return
            println("当前遍历的值是 $item")
        }
        println("list集合遍历完成")
    }




}