package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.applybean.*
import com.example.kotlin.bean.reflect.UserJ
import com.example.kotlin.bean.reflect.UserK
import com.example.kotlin.bean.reflect.User
import com.example.kotlin.inherit.class1.Foo

/**
 * 反射（引用）
 *   https://blog.csdn.net/ccw0054/article/details/79045933
 *
 *   https://blog.csdn.net/qq_33505109/article/details/81031717
 */
class ReflectActivity : AppCompatActivity() {

    val x = 1

     var b = 5


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)

//        myClass()

//        kdyyy()

        reference()
    }
    //类引用
    private fun myClass(){
        /*

            最基本的反射功能是获取 Kotlin 类的运行时引用。要获取对静态已知的 Kotlin 类的引用，可以使用 类字面值 语法：

        */

        //该引用是 KClass 类型的值。
        val c = User::class

        //请注意，Kotlin 类引用与 Java 类引用不同。要获得 Java 类引用， 请在 KClass 实例上使用 .java 属性。
        val javaC = User::class.java

        //该引用获取的值应该等价于::class.java
        val kProperty = User::javaClass


    }/*
    可调用引用
    函数、属性以及构造函数的引用，可以作为 lambda 函数直接被使用。

    所有可调用引用的公共超类型是 KCallable， 其中 R 是返回值类型，对于属性是属性类型，对于构造函数是所构造类型。*/
    private fun kdyyy(){

        //todo 函数引用
        fun isOdd(x: Int) = x % 2 != 0

        //可以通过引用的形式将其转换成 lambda 函数，让我们更加简单的对其进行调用。
        val numbers = listOf(1, 2, 3)
        numbers.filter(::isOdd)

        //这里 ::isOdd 是函数类型(Int) -> Boolean的一个值。可以写成以下的形式：
        val predicate: (Int) -> Boolean = ::isOdd
        val numbers2 = listOf(1, 2, 3)
        numbers2.filter(predicate)

        //todo 属性引用

        //表达式 ::x 求值为 KProperty 类型的属性对象，它允许我们使用 get() 读取它的值，或者使用 name 属性来获取属性名。更多信息请参见
        println(::x)//返回x属性的声明
        println(::x.get())//返回属性的值
        println(::x.name)//返回属性的名称

        ::b.set(10)//通过属性引用的方式来改变量的值
        println(b)
        println(::b.get())

        println("属性引用在函数的应用~~~~~~~~~~~~~~~~~")
        //属性引用在函数的应用：
        val valuse = listOf("a","abd","abcd")
        println(valuse.map(String::length))
        println(valuse.map{it.toString()})


        val v = MyClass::x
        //获取该属性的值时就需要指定receiver了
        println(v.get(MyClass(10)))//MyClass(10)需要传一个接收者


        println("扩展属性~~~~~~~~~~~~~~~~~")
        //扩展属性
        //给String系统类添加一个扩展属性
        println(String::firstChat.get("xyz"))//"xyz"也需要传一个接受者


        //todo 构造函数引用
        function(::Foo)
    }


    fun function(factory: () -> Foo) {
        val x: Foo = factory()
    }

    /*
    https://blog.csdn.net/qq_33505109/article/details/81031717
    1.反射
    1.1类引用
    1.2函数引用
    1.3属性引用*/
    private fun reference(){
        //反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性，这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。Kotlin中使用反射功能所需的运行时组件作为单独的 JAR 文件（kotlin-reflect.jar）分发。这样做是为了减少不使用反射功能的应用程序所需的运行时库的大小。如果用Android Studio运行Kotlin项目，一般会在创建工程时，自动引入（kotlin-reflect.jar）
        //todo 类引用
        //在Kotlin中，用类名+两个冒号::+class（如果是java类要在后面加上.java）表示获取这个类的对象。
        //如果User是Kotlin的类
        var user = User::class
        //如果User是Java的类
        var userj = UserJ::class.java

        //todo 函数引用
        //方式一
        //获取printUserName函数对象
        var p = UserK::printUserName
        //调用invoke()函数执行printUserName函数
        p.invoke(UserK("Czh"))

        //方式二
        //利用Java反射机制获取getUserName方法
//        var getName = UserJ::class.java.getMethod("getUserName")
//        //利用Java反射机制获取setUserName方法
//        var setName = UserJ::class.java.getMethod("setUserName", java.lang.String().javaClass)
//        //设置属性值
//        setName.invoke(userj, "Harden")
//        //获取属性值
//        println(getName.invoke(userj))

        //在Kotlin中，可以用类名+两个冒号::+函数名直接获取这个函数的对象；或者利用Java反射机制调用getMethod()方法来获取函数的对象。

     println("属性引用～～～～～～～～～～")
        //属性引用

        //方式一
        var user1 = User()
       //获取属性对象
        var userName = User::userName
        println(userName.get(user1))
        //设置属性值
        userName.set(user1, "James")
        //获取属性值
        println(userName.get(user1))

        //方式二
        //利用Java反射机制获取getUserName方法
        var getName = User::class.java.getMethod("getUserName")
        //利用Java反射机制获取setUserName方法
        var setName = User::class.java.getMethod("setUserName", java.lang.String().javaClass)
        //设置属性值
        setName.invoke(user, "Harden")
        //获取属性值
        println(getName.invoke(user))

        //在Kotlin中，可以用类名+两个冒号::+属性名直接获取属性对象；或者通过Java反射机制获取属性的get/set方法来获取或修改属性值。

    }





}
//x属性定义在MyClass当中了
class MyClass(val x: Int)

//给String系统类添加一个扩展属性
val String.firstChat:Char
    get() = this[0]