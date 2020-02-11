package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * for循环  in
 */
class InActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)






        //..语法不仅可以创建数字区间，还可以创建字符区间
        for(i in 1..100){

        }
        for (i in 1 until 100){

        }
        for (i in 'A'..'F'){

        }

        val list1 = listOf("Hello"," ", "World"," ",'!')
        for(s in list1){
            print(s)
        }

      /*
        0..9 指的是[0,9]这个集合，0和9都包含。
        0 until 9 指的是[0,9)，包含0不包含9。

        */


        //使用关键字in来迭代区间或者集合
        val list = arrayListOf("10","11","101");
        //迭代集合时使用下标
        for ((index,element) in list.withIndex()){
            Log.e("fxj","$index:$element");
        }

        //使用in来检查区间或者集合是否包含了某个值



        //Kotlin中的循环
        forCycle()
        iterator()
        repeat()
    }

    //for循环
    fun forCycle(){
        println("for循环~~~~~~~~~~~~~~~~~~~~~")
        //最普通的for循环：
       /* 0..9 指的是[0,9]这个集合，0和9都包含。
        0 until 9 指的是[0,9)，包含0不包含9。*/
        for(i in 0..9){
            println(i)
        }


        //倒序遍历就该使用标准库中定义的downTo()函数：
        for (index in 100 downTo 1){
            print(index)
        }

        //想不使用1作为遍历的步长，可以使用step()函数：
        for (index in 1..100 step 2){
            print(index)//会输出1..3..5......
        }

        //要创建一个不包含末尾元素的区间：
        for (index in 1 until 10){
            println(index)//输出0..9
        }


        //遍历取元素：
        //用for循环遍历集合中的值：
        val list = listOf("Hello"," ", "World"," ",'!')
        for(s in list){
            print(s)
        }


        //遍历一个数组/列表，想同时取出下标和元素：
        //带着index遍历集合
        val fruits = listOf("苹果","香蕉","橙子","西瓜")
        for((index, element) in fruits.withIndex()){
            println("第${index}种水果是$element")
        }

        //遍历一个数组/列表，只取出下标:
        val array = arrayOf("a", "b", "c")
        for (index in array.indices){
            println("index=$index")//输出0，1，2
        }


        //比较特殊的forEach语法
        val list2 = listOf("Hello", "World",'!')
        list2.forEach{
            print("$it ")  //这里的it指代被遍历的list中的值
        }

    }
    //https://blog.csdn.net/aqi00/article/details/82699463
    //迭代器循环
    fun iterator(){
        println("迭代器循环~~~~~~~~~~~~~~~~~~~~~")
    }

    //While循环
    fun whileCycle(){
        println("While循环~~~~~~~~~~~~~~~~~~~~~")
        //while和do-while循环和java保持一致。
//        while(condition) {
//            doSomething()
//        }
//
//        do {
//            doSomething()
//        } while (condition)

    }

    //Repeat语法
    fun repeat() {
        println("Repeat语法~~~~~~~~~~~~~~~~~~~~~")
        //这是Kotlin相对于Java新加入的特性，取代for(int i=0;i<5;i++)用于简单的重复工作。
        repeat(5){ i ->
            println("循环运行第${i+1}次。")
        }
    }

    //跳跃语法
    fun jumping(){
        println("跳跃语法~~~~~~~~~~~~~~~~~~~~~")
        //Kotlin中引入了标签的概念，可以直接控制程序应该执行的代码是什么。
        //标签后面用@标明。

//        loop@ for(i in 1..100){
//            for(j in 1..100){
//                if(...) break@loop
//            }
//        }

        //这段代码中的break将会跳出带有loop@标签的循环。continue和break的用法一样。
    }


}