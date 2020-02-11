package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * 数组
 */
class ArrayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        createArray()

        accessingArray()

        modifyArray()

        traverseArray()


    }
    //一、创建数组
    fun createArray(){
        //1.arrayOf

        //使用此函数时，必须设定数组的元素。因在元素中已给出具体的元素类型，所以不需要使用泛型来指定元素类型。
        var intArr1 = arrayOf(1, 2, 3, 4, 5)
        var strArr1 = arrayOf("A", "B", "C", "D", "E")


        //2.arrayOfNulls

        //必须指定数组长度以及元素类型。
        var intArr2 = arrayOfNulls<Int>(5);
        var strArr2 = arrayOfNulls<String>(5)


        //3.emptyArray

        //必须指定元素类型，用于创建空数组。
        var intArr3 = emptyArray<Int>()
        var strArr3 = emptyArray<String>()

    }

    //二：访问数组
    fun accessingArray(){
        //在Java中访问数组元素都是通过[]加索引值来访问，而这点在Kotlin中有所不同。Kotlin是通过get(int index)函数来访问数组元素的。
        var intArr1 = arrayOf(1, 2, 3, 4, 5)
        var value = intArr1.get(1)
//        toast("value:"+value)
        Log.e("fxj","value:"+value);
        //以上的访问数组元素value值为2。在Kotlin中索引值也是从0开始计算的。需要说明，在Kotlin中同样支持[]访问数组元素，intArr1[1]也一样访问到元素2、
    }
    //三：修改数组
    fun modifyArray(){
        //在Kotlin中使用set(index: Int, value: T)来修改数组元素。
        var intArr1 = arrayOf(1, 2, 3, 4, 5)
        var value = intArr1.get(1)
        intArr1.set(1,100)
        value = intArr1.get(1)
        Log.e("fxj","value2:"+value);
    }

    //四、循环遍历数组
    fun traverseArray(){
        //1 采用 for (i in 0 until xx.size) 循环

        //此遍历的函数代码字面意思很明确，就是循环到xx.size。比Java中的for循环代码更直接
        var strArr1 = arrayOf("A", "B", "C", "D", "E")
        for (i in 0 until strArr1.size){
            Log.e("fxj",  "strArr1:  " + strArr1.get(i))
        }

        //2 采用 for-in 循环

        var strArr2 = arrayOf("A", "B", "C", "D", "E")
        for(str in strArr2){
            Log.e("fxj",  "str:  " + str)
        }
    }


}