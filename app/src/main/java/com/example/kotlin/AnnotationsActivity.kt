package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * 注解
 */
class AnnotationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        println("注解~~~~~~~~~~~~~~~~~~~~~~")
        /*
            以@字符作为注解名字的前缀，并放在要注解的声明最前面


    compile "org.jetbrains.kotlin:kotlin-reflect:$kotlin_version"
        */
        
        
//        val person = Person("Alice",29)
//        println(person)
//        println(serialize(person))
//
//        // 测试代码
//        val p = Person("better", 30)
//        println(serialize(p))

    }

}