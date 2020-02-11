package com.example.kotlin

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.testbean.Dog
import com.example.kotlin.testbean.Person

/**
 * Kotlin -特殊用法详解 高级用法
 */
class SeniorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        deconstructionStatement()

//        companion()
    }
    //todo 解构声明  https://www.douban.com/note/722348918/
    @TargetApi(Build.VERSION_CODES.N)
    private fun deconstructionStatement(){
        //解构声明可以一次创建多个变量，通常用于数据类当中
        val (name, age) = Person("tom", 11)
        println(name)
        println(age)



        val person = Person("tom", 22)
        println(person.age)

        val name1 =person.component1()
        val age2 =person.component2()
        println(name1)
        println(age2)

        //上面的Person是数据类（data class）当我们定义一个普通的类,不能简单的通过下面的方法获取name和age的值
//        val (nameDog, ageDog) = Dog("James", 5)
        //为什么数据类可以，普通类就不可以呢？ 因为数据类帮我们实现了解构声明需要的componentN方法这个N可以是1或者2等.





        //https://www.jianshu.com/p/f033158857d4
        //解构声明同样可以用在循环当中：

        val list: List<Person> = listOf(Person("one", 1),
            Person("two", 2),
            Person("three", 3),
            Person("four", 4))
        list.forEach { (name, age) ->
            println("name:$name, age:$age")
        }



        //解构声明也可以用在函数中，从函数中返回值：
        val (name3, age3) = getPair("jowan", null)
        println("name:$name3, age:$age3") // 打印name:jowan, age:23



/*
        解构声明还可以Map中

        前提条件是：

        通过提供一个iterator()函数将映射表示为一个值的序列
                通过提供函数component1()和component2()来将每个元素呈现为一对*/
        val map: Map<String, Int> = mapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
        map.forEach { (name, age) ->
            println("name:$name, age:$age")
        }


        //如果在解构声明中有用不到的变量，则可以使用下划线代替

        val (_, age4) = getPair()
        println("age:$age4") // 打印出age:1



        //如果Lambda具有Pair类型的参数（或Map.Entry或具有相应componentN函数的任何其他类型），则可以通过将它们放在括号中来引入几个新参数：
        val map2 = mapOf(1 to 1, 2 to 2, 3 to 3)
        map2.forEach {
                entry ->
            println("${entry.value}!")
        }
        map2.forEach {
                a, b ->
            println("$a!$b!")
        }

//        注意声明参数和声明解构对之间的区别：
//        { a -> ... }一个参数：

        val map3 = mapOf(1 to 1, 2 to 2, 3 to 3)

        map3.forEach {
                entry ->
            println("${entry.value}!") // 打印1!2!3!
        }

        //{ a, b -> ... }两个参数：
        val map4 = mapOf(1 to 1, 2 to 2, 3 to 3)

        map4.forEach {
                a, b ->
            println("$a!$b!") // 打印1!1!2!2!3!3!
        }

        //{ (a, b) -> ... } 一个Pair类型的解构：
        val map5 = mapOf(1 to 1, 2 to 2, 3 to 3)
        map5.forEach {
                (_, value) ->
            println("$value!") // 打印1!2!3!
        }

        //{ (a, b), c -> ... }一个Pair类型的解构和一个参数：
        val maps = mapOf((1 to 1) to 3, (2 to 2) to 2, (3 to 3) to 1)

        maps.forEach { (a, b), c ->
            println("$a!$b!$c") // 打印1!1!32!2!23!3!1
        }

        //解构声明也可以指定解构的类型：
        map.mapValues { (_, value) -> "$value!" }

//        map.mapValues { (_, value): Map.Entry<Int, String> -> "$value!" }
//
//        map.mapValues { (_, value: String) -> "$value!" }

    }
    private fun companion(){

    }

    fun getPair(after: String?, afterAge: Int?): Pair<String, Int> {
        var name = "wangzai"
        var age = 23
        // 处理返回的数据
        name = after ?: name
        age = afterAge ?: age
        return Pair(name, age)
    }
    fun getPair(): Pair<String, Int> {
        return Pair("one", 1)
    }

}