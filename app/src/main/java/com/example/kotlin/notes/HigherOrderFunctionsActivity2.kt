package com.example.kotlin.notes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_other.*

/**
 * 高阶函数  https://www.jianshu.com/p/27ed7e4e1259
 *
 *
 *      https://blog.csdn.net/jeffrey_feng2018/article/details/80754784
 */
class HigherOrderFunctionsActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        tv_01.text="高阶函数"
        println("高阶函数2~~~~~~~~~~~~~~~~~~~~~~")
        /*
            高阶函数的基本概念:

            传入或者返回函数的函数

            函数引用 ::println

            带有Receiver的引用  pdfPrinter::println

        */

//        forEach()
//
//        map()
//
//        flatMap()

//        reduce()

//        fold()

//        foldRight()

//        filterIndexed()

//        takeWhile()

        let()

    }

    //forEach 遍历
    fun forEach(){
        println("forEach~~~~~~~~~~~~~~~~~~~~")
        var list = listOf(1, 2, 3, 4, 5, 6)
        list.forEach(::println)

        list.forEach { println("forEach：$it") }
//        list.forEach { println(it) }

        val newList = arrayListOf<String>()
        list.forEach {
            newList.add((it * 2).toString())
//            newList.add(it.toString())
        }
        newList.forEach(::println)
    }

    //map 变换
    fun map(){
        println("map~~~~~~~~~~~~~~~~~~~~")
        val list = listOf(1, 2, 3, 4, 5, 6)
        val newList = list.map {
            //对集合中的数据进行操作，然后赋值给新的集合
            (it * 2).toString()
        }.forEach(::println)

        val doubleList = list.map {
            it.toDouble()
        }.forEach(::println) //1.0 2.0 3.0 4.0 5.0 6.0
        //函数作为参数的第二种方式调用 类名::方法名
        val doubleList2 = list.map(Int::toDouble).forEach(::println) ////1.0 2.0 3.0 4.0 5.0 6.0




        val list2:Array<Int> = arrayOf(1,2,3,4,5,6,7,8)
        val newList2 = list2.map {
            it*5+10
        }
        val doubleList3 = list2.map(Int::toDouble)
        newList2.forEach(::println)
        doubleList3.forEach(::println)

    }
    //flatMap 对集合的集合进行变换
    fun flatMap(){
        println("flatMap~~~~~~~~~~~~~~~~~~~~")
        val list = arrayOf(
            1..5,
            50..55
        )

        //把多个数组集合变成一个数组，并且对数据进行变换
        val mergeList = list.flatMap { intRange -> //集合内的集合 1..5 , 50..55
            intRange.map { intElement -> //集合内集合遍历 1,2,3,4,5
                "No.$intElement"
            }
        }
        //No.1 , No.2 , No.3 , No.4 , No.5 , No.50 , No.51 , No.52 , No.53 , No.54 , No.55 ,
        mergeList.forEach { println("$it , ") }
        println("----------------------------")
        //直接多个数组集合变换成一个结集合
        val newList = list.flatMap {
            it
        }
        //1 , 2 , 3 , 4 , 5 , 50 , 51 , 52 , 53 , 54 , 55 ,
        newList.forEach { println("$it , ") }

        println("----------------------------")

        val list2 = arrayOf(
            1..10,
            20..30,
            50..100
        )

        val mergeList2 = list2.flatMap {
            it.map {
                "No.$it"
            }
        }
        mergeList2.forEach(::println)


    }
    //使用reduce对集合进行计算操作
    fun reduce(){
        println("reduce~~~~~~~~~~~~~~~~~~~~")
//        val list = arrayOf(
//            1..10,
//            20..30,
//            50..100
//        )
        val list = arrayOf(
            1..5,
            10..11
        )

        val mergeList = list.flatMap { it }
        mergeList.forEach(::println)
        println("总和：${mergeList.reduce(Int::plus)}")

        //求和 reduce 返回值必须是 acc类型
        println("总和：${mergeList.reduce { acc, i -> acc + i }}")
        println("----------------------------")
        /**
         * 方式1
         */
        (0..6).map {
            factorial(it)
        }.forEach(::println)
        println("----------------------------")
        /**
         * 方式2
         */
        (0..6).map(::factorial).forEach(::println)
    }

    /**
     * 求阶乘
     */
    fun factorial(int: Int): Int {
        if (int == 0) return 1
        return (1..int).reduce { acc, i -> acc * i }
    }

    //使用fold对集合进行自定义计算
    fun fold(){
        println("fold~~~~~~~~~~~~~~~~~~~~")

        /**
         * 对集合进行转化和拼接
         */
        val _str: String = (0..10).joinToString(",")
        println(_str)//0,1,2,3,4,5,6,7,8,9,10

        println("----------------------------")

        /**
         * 添加一个初始值
         * 打印结果=》9
         */
        println((0..1).fold(8) { acc, i ->
            acc + i
        })

        println("----------------------------")
        /**
         * 添加一个StringBuilder的初始值与集合中的元素进行计算操作
         */
        val _str1 = (0..5).fold(StringBuilder()) { acc, i ->
            acc.append(i).append(",")
        }
        println(_str1)

    }

    //reduce ，fold，foldRight 倒叙, joinToString转换字符去
    fun foldRight(){
        println("reduce ，fold，foldRight 倒叙, joinToString转换字符去~~~~~~~~~~~~~~~~~~~~")
        val list = arrayOf(
            1..5,
            2..3
        )

        val newList = list.flatMap {
            it
        }
        newList.forEach { println("$it , ") }

        //求和 reduce 返回值必须是 acc类型
        println(newList.reduce { acc, i -> acc + i }) //20


        //带基数求和
        println(newList.fold(10) { acc, i -> acc + i }) //30


        //fold 返回值类型是 "基数" 对应的类型,比如 StringBuilder hello--1--2--3--4--5--2--3--
        println(newList.fold(StringBuilder("hello--")) { acc, i -> acc.append(i).append("--") }) //30


        //拼接字符串 1---, 2---, 3---, 4---, 5---, 2---, 3---
        println(newList.joinToString { "$it---" })

    }

    //filter 筛选   filterIndexed 下标筛选
    fun filterIndexed(){
        println("filter 筛选 filterIndexed 下标筛选~~~~~~~~~~~~~~~~~~~~")
        val list = arrayOf(
            1..5,
            2..3
        )
        val newList = list.flatMap {
            it
        }
        //筛选 集合中数据 > 2的item
        val filterList = newList.filter { it > 2 }
        filterList.forEach(::print) //3453
        //筛选 集合中下标是奇数item
        val filterIndexList = newList.filterIndexed { index, i -> index % 2 == 0; }
        filterIndexList.forEach { print(it) } //1 3 5 3

    }

    //takeWhile 截至条件
    fun takeWhile(){
        println("takeWhile 截至条件~~~~~~~~~~~~~~~~~~~~")

        val list = arrayOf(
            1..5,
            2..3
        )
        val newList = list.flatMap {
            it
        }
        //截取符合条件的前面的所以的item 1234523，< 3 ，12
         newList.takeWhile { it < 3 }.forEach { println(it) } // 1 2
        println("----------------------------")
        //返回包含 最后[n]元素 的列表。，包含最后2个元素
        newList.takeLast(2).forEach(::println) // 23

    }

    //?. 判空执行，let 类作为参数，apply 类扩展
    fun let(){
        println("?. 判空执行，let 类作为参数，apply 类扩展~~~~~~~~~~~~~~~~~~~~")

        val person = getPerson()
        println(person?.name) //判空处理，如果不为空 执行后面的方法

        person?.let { //类作为参数 it
            println(it.name)
            println(it.age)
            it.work()
        }

        person?.apply { //类扩展 可以直接调用
            println(name)
            println(age)
            work()
        }
    }

    fun getPerson(): Person? {
        return Person(
            "shadow",
            18
        )
//        return null
    }

    class Person(val name: String, val age: Int) {
        fun work() {
            println("hello shadow")
        }
    }
    /*
    with

    定义：fun <T, R> with(receiver: T, block: T.() -> R): R
    功能：将对象作为函数的参数，在函数内可以通过 this指代该对象。返回值为函数的最后一行或return表达式。
*/
    fun with(){
        println("with~~~~~~~~~~~~~~~~~~~~")
    }



}