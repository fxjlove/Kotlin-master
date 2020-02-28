package com.example.kotlin.notes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.kotlin.R

//导入扩展函数
import com.example.kotlin.ext.*
import kotlinx.android.synthetic.main.activity_other.*
//import com.example.demo2.util.lastChat

//import com.example.demo2.ext.lastChar3
//import java.lang.StringBuilder

//可以使用关键字as来修改导入的类或者函数名称
import com.example.kotlin.ext.lastChat as last

/**
 * 扩展函数
 */
class ExtensionFunctionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        println("扩展函数~~~~~~~~~~~~~~~~~~~~~~")

//        val c = "Kotlin".lastChat()

        val c = "Kotlin".last()
        println(c)

        //可以像访问使用成员属性一样访问它
         val sb = StringBuilder("kotlin")
        sb.lastChar3 = '！'
        println(sb)

        val version = this.getAppVersion()

//        tv_01.text = "河北省null南宫市".toNoNullString()

        //这样在为TextView设置text时就会执行下面的方法来设置属性，
        tv_01.noNullText= "河北省null南宫市"

    }
    //扩展属性 添加扩展属性时需要使用set和get方法，唯一的不同是在属性前面加上扩展的类型，
/*
    必须定义get()方法，在Kotlin中类中的属性都是默认添加get()方法的，但是由于扩展属性并不是给现有库中的类添加额外的属性，自然就没有默认get()方法实现之说。所以必须手动添加get()方法。

    由于重写了set()方法，说明这个属性访问权限是可读和可写，需要使用var
    */
    var TextView.noNullText: String?
        get():String? {
            return text as String?
        }
        set(value){
            text = value?.replace("null","")?:""
        }

    //扩展函数
    fun String?.toNoNullString(): String?{
        // ?. 表示对象为空时就直接返回null    ?: 表示为空时就返回右边的值
        return this?.replace("null","")?:""
    }
    fun String?.toNoNullString2(): String? = this?.replace("null","")?:""


    /*
      扩展函数
      String 接收者类型
      this 接收者对象

  */

    fun String.lastChat(): Char = this.get(this.length-1)


    //接收者对象可以不用this来访问
    fun String.lastChat2(): Char = get(length-1)


}
