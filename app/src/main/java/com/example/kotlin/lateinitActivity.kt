package com.example.kotlin

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.ui.RVAdapter
import org.jetbrains.anko.toast

/**
 * lateinit
 */
class lateinitActivity : AppCompatActivity() {
    private var mContext: Context? = null

    //Koltin中属性在声明的同时也要求要被初始化，否则会报错
//    private var name0: String //报错
    private var name1: String = "xiaoming" //不报错
    private var name2: String? = null //不报错


    //lateinit var
    private lateinit var name: String



    //用于属性延迟初始化
    val name3: Int by lazy { 1 }


    private var adapter: RVAdapter? = null
    private var nullTest: String? = null

    private lateinit var adapter2: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        /*


        lateinit 延迟加载  延迟初始化


        lateinit修饰的变量/属性不能是 原始数据类型
        Kotlin 的基本数值类型包括 Byte、Short、Int、Long、Float、Double 等。不同于 Java 的是，字符不属于数值类型，是一个独立的数据类型。

        lateinit 只能修饰, 非kotlin基本类型
        因为Kotlin会使用null来对每一个用lateinit修饰的属性做初始化，而基础类型是没有null类型，所以无法使用lateinit。


        Kotlin中有两种延迟初始化的方式。一种是lateinit var，一种是by lazy。


        lateinit var只能用来修饰类属性，不能用来修饰局部变量，并且只能用来修饰对象，不能用来修饰基本类型(因为基本类型的属性在类加载后的准备阶段都会被初始化为默认值)。
        lateinit var的作用也比较简单，就是让编译期在检查时不要因为属性变量未被初始化而报错。

         */

//        lateInitVar = "";
//        checkInit()

//        if (name2.equals("aa")){
//            toast("true1")
//        }else{
//            toast("false1")
//        }

        adapter?.notifyDataSetChanged()

        nullTest?.isEmpty()

        //没有初始化会报错
        adapter2.notifyDataSetChanged()
    }
    //用于局部变量延迟初始化
    public fun foo() {
        val bar by lazy { "hello" }
        println(bar)

    }


    lateinit var lateInitVar: String

    //Android开发Kotlin检查lateinit变量是否已初始化的方法
    fun checkInit() {
        if(this::lateInitVar.isInitialized){//重要，this::前缀是必须的。
            //如果已经初始化了，返回true 　
            toast("true")
        }else{
            toast("false")
            //若没有初始化报错：属性lateInitVar尚未初始化 lateinit property lateInitVar has not been initialized
            if (lateInitVar.equals("aa")){
                toast("true1")
            }else{
                toast("false1")
            }
        }

    }

}