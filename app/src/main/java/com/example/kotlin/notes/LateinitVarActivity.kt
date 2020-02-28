package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * 从原理分析Kotlin的延迟初始化: lateinit var和by lazy
 */
class LateinitVarActivity : AppCompatActivity() {

    //Koltin中属性在声明的同时也要求要被初始化，否则会报错

//    private var name0: String //报错
    private var name1: String = "xiaoming" //不报错
    private var name2: String? = null //不报错

    var name3: String = "xiaoming" //不报错
    var name4 = "xiaoming"
    var name5: String = "" //不报错

    var data = ArrayList<String>()


    val a: Int = 1
    val b = 1  // 系统自动推断变量类型为Int


    //有的时候，我并不想声明一个类型可空的对象，而且我也没办法在对象一声明的时候就为它初始化，那么这时就需要用到Kotlin提供的延迟初始化。
    //Kotlin中有两种延迟初始化的方式。一种是lateinit var，一种是by lazy。

    //lateinit var

    private lateinit var name: String

//     lateinit var只能用来修饰类属性，不能用来修饰局部变量，并且只能用来修饰对象，不能用来修饰基本类型(因为基本类型的属性在类加载后的准备阶段都会被初始化为默认值)。
//      lateinit var的作用也比较简单，就是让编译期在检查时不要因为属性变量未被初始化而报错。
//      Kotlin相信当开发者显式使用lateinit var 关键字的时候，他一定也会在后面某个合理的时机将该属性对象初始化的(然而，谁知道呢，也许他用完才想起还没初始化)。

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)


    }


}