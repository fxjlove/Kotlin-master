package com.example.kotlin.notes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.annotation.TestAnnotation

/**
 * 注解  https://blog.csdn.net/u013064109/article/details/89498669
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



/*
        在很多常见的Java或Kotlin框架中大量使用了注解，比如我们最常见的JUnit单元测试框架
        class ExampleUnitTest {
            @Test //@Test注解就是为了告诉JUnit框架，这是一个测试方法，当做测试调用。
            fun addition_isCorrect() {
                assertEquals(4, 2 + 2)
            }
        }


        Kotlin中的元注解
        和Java一样在Kotlin中，一个Kotlin注解类自己本身也可以被注解，可以给注解类加注解。我们把这种注解称为元注解，可以把它理解为一种基本的注解，可以把它理解为一种特殊的标签，用于标注标签的标签。

        Kotlin中的元注解类定义于kotlin.annotation包中，主要有: @Target、@Retention、@Repeatable、@MustBeDocumented 4种元注解相比Java中5种元注解: @Target、@Retention、@Repeatable、@Documented、@Inherited少了 @Inherited元注解。

     @Target元注解

     */


    }
    //todo 注解的应用
    //Kotlin中使用注解和Java一样。要应用一个注解都是 @注解类名。

    //给test函数贴上TestAnnotation标签(添加TestAnnotation注解)
    @TestAnnotation(value = 1000)
    private fun test(){

    }


}