package com.example.kotlin.notes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.kotlin.R

/**
 * ArrayList 集合
 */
class ArrayListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        /**
         *   1、listOf()
         *   2、listOfNotNull()
         *   3、mutableListOf()
         *   4、arraylistOf()
         */

        createArrayList()

        getArryListElement()

        modifyArryListElement()


    }
    //一、创建不同 ArrayList
    fun createArrayList(){
        //1 listOf()

        var list = listOf("A", "B", "C")
        Log.e("TEST", list.toString())//输出：[A, B, C]

        var list2 = listOf(null)
        Log.e("TEST", list2.toString())//输出：[null]


        //2 listOfNotNull()

        var list3 = listOfNotNull("A", "B", "C", null)
        Log.e("TEST", list3.toString())//输出：[A, B, C]

        var list4 = listOfNotNull(null)
        Log.e("TEST", list4.toString())//输出：[]



        //3 mutableListOf()

        var list5 = mutableListOf("A", "B", "C", null)
        Log.e("TEST", list5.toString())//输出：[A, B, C, null]

        var list6 = mutableListOf(null)
        Log.e("TEST", list6.toString())//输出：[null]



        //4 arraylistOf()
        var list7 = arrayListOf("A", "B", "C", null)
        Log.e("TEST", list7.toString())//输出：[A, B, C, null]

        var list8 = arrayListOf(null)
        Log.e("TEST", list8.toString())//输出：[null]


        //总结：可以看到以上不同的 ArrayLit 创建时加入 null 值，在 listOfNotNull() 中是不能输出的。所以可以在不能加入 null 的 List 中使用 listOfNotNull()。


    }
    //二、获取 ArrayList 中的元素
    fun getArryListElement(){
        Log.e("TEST","获取 ArrayList 中的元素~~~~~~~~~~~~~~")
        //在 Kotlin 中 ArrayList 的索引也是从0开始计算的。

        //1 循环遍历 ArrayList 元素

        var list = mutableListOf("A", "B", "C")
        for (i in 0 until list.size){
            Log.e("TEST", "list: " + list.get(i))
        }

        for (value in list){
            Log.e("TEST", "list2: " +value)
        }

        //2 获取 ArrayList 指定的子集合
        //println(list.subList(1, 2))
        Log.e("TEST", list.subList(1, 2).toString())//输出：[B]



        val list2 = arrayListOf("10","11","101");
        //迭代集合时使用下标
        for ((index,element) in list2.withIndex()){
            Log.e("TEST","$index:$element");
        }

        //获取列表中最后一个元素
        Log.e("TEST", list.last())//输出：C

        //得到数字列表的最大值
        val numbers = setOf(1,14,2);
        Log.e("TEST", ""+numbers.max())//输出：14

    }


    //三、修改 ArrayList 中的元素。
    fun modifyArryListElement(){
        Log.e("TEST","修改 ArrayList 中的元素~~~~~~~~~~~~~")
        //因在 Kotlin 的 ArrayList 提供的函数中存在可变集合和不可变集合的概念，所以并不是所有的 ArrayList 都支持修改元素。mutableListOf()、arraylistOf()是支持可变集合的。此处所讲述的修改 ArrayList 就是代表增、删、改。

        //1 插入元素
        //插入元素以下代码实例主要是指在对应的 index 位置插入新的元素。

        var list = mutableListOf("A", "C")
        Log.e("TEST", list.toString())
        list.add(1, "B")
        Log.e("TEST", list.toString())


        //2 删除元素
        var list2 = mutableListOf("A", "B", "C")
        Log.e("TEST", "list2:"+list2.toString())
        list2.removeAt(1)
        Log.e("TEST", "list2:"+list2.toString())


        //3 修改元素
        var list3 = mutableListOf("A", "B", "C")
        Log.e("TEST", list3.toString())
        list3[1] = "A"
        Log.e("TEST", list3.toString())
    }

}