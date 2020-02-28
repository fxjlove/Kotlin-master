package com.example.kotlin.notes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_other.*

/**
 * flatMap
 */
class FlatMapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        tv_01.text="flatMap"


        mapAndFlatMap()

        mapAndFlatMap2()

    }


    fun mapAndFlatMap(){
        println("map与flatMap~~~~~~~~~~~~~~~~~~~~")
        /*
            map：遍历每一个元素

            flatMap：遍历每一个元素，并铺平元素

        */
        var list =listOf(listOf(10,20),listOf(30,40),listOf(50,60))

        var mapList = list.map{element->element.toString()}
        println(mapList)//[[10, 20], [30, 40], [50, 60]]

        var mapList2 = list.map { it }
        println(mapList2)//[[10, 20], [30, 40], [50, 60]]

        var flatMapList = list.flatMap{element->element.asIterable()}
        println(flatMapList)//[10, 20, 30, 40, 50, 60]
        var flatMapList2 = list.flatMap{it.asIterable()}
        println(flatMapList2)//[10, 20, 30, 40, 50, 60]
    }
    fun mapAndFlatMap2(){
        println("map与flatMap2~~~~~~~~~~~~~~~~~~~~")
        /*
            flatMap  遍历所有的元素 ，为每一个创建一个集合 ，最后把所有的集合放在一个集合中。

            map     返回一个每一个元素根据给定的函数转换所组成的List
        */
        val list= listOf(1,2,3,4,5)
        val list2=list.map { listOf(it+1) }
        list2.map { println("my value is ${it}") }
        println(list2)
        println("----------------------------")
        val list3 = list.flatMap { listOf(it+1) }
        list3.map { println("my value is ${it}") }
        println(list3)


        //下面使用map跟flatMap达到同样的效果
        val listA= listOf(1,2,3,4,5)
        val list2A=list.map { it+1 }
        list2A.map { println("my value is ${it}") }
        println(list2A)
        println("--------------------------------------------------------")
        val list3A = listA.flatMap { listOf(it+1) }
        list3A.map { println("my value is ${it}") }
        println(list3A)
    }


}