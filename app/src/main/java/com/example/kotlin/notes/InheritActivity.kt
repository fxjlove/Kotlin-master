package com.example.kotlin.notes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.R
//import 包名.函数名来导入我们将要使用的函数
import com.example.kotlin.inherit.*
import com.example.kotlin.inherit.class1.User2
import com.example.kotlin.inherit.generic.Box
import com.example.kotlin.interface1.Child
import com.example.kotlin.interface1.D
import com.example.kotlin.interface1.MyImpl
import com.example.kotlin.interface1.inter2.PrivateUser
import com.example.kotlin.interface1.inter2.SubscribingUser

/**
 * 继承
 */
class InheritActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        //kotlin在类名后面使用冒号来代替了java中的extends和implements关键字，和java一样，一个类可以实现任意多个接口，但是只能继承一个类

        /*
        修饰符     相关成员
        final       不能被重写
        open         可以被重写
        abstract        必须被重写
        override        重写父类或接口中的成员



        可见性修饰符：默认为public
        修饰符             类成员              顶层声明
        public（默认）      所有地方可见          所有地方可见
        internal           模块中可见            模块中可见
        protected           子类中可见            --
        private             类中可见             文件中可见
      */
        val s =  Student("Runoob", 18, "S12346", 89)
        println("继承~~~~~~~~~~~~~~~~~~~~")
        println("学生名： ${s.name}")
        println("年龄： ${s.age}")
        println("学生号： ${s.no}")
        println("成绩： ${s.score}")

         Student2("Runoob", 18, "S12345", 89)

        val s4 =  Student4();
        s4.study()

        val c =  C()
        c.f()

        val child =  Child()
        child.foo();
        child.bar();

        val lm =  MyImpl()
        println(lm.name)

        //实现多个接口时，可能会遇到同一方法继承多个实现的问题。
        val d =  D()
        d.foo();
        d.bar();
        println("")
        val user1 = User("Alice")
        println(user1.inSubscribed)

        val user2 = User("Bob",false)
        println(user2.inSubscribed)

        val user3 = User("carol",inSubscribed = false)
        println(user3.inSubscribed)


        println("在接口中声明属性~~~~~~~~~~~~~~~~~~~~")
        val userP = PrivateUser("test@kotlinlang.org").nickname
        println(userP)

        val userS = SubscribingUser("test@kotlinlang.org").nickname
        println(userS)


        println("通过getter或setter访问支持字段~~~~~~~~~~~~~~~~~~~~")
        val userU = com.example.kotlin.inherit.class1.User("Alice")
        userU.address = "AAA"


        println("数据类data~~~~~~~~~~~~~~~~~~~~")
        val jack = User2(name = "Jack", age = 1)
        val olderJack = jack.copy(age = 2)
        println(jack)
        println(olderJack)

        println("数据类以及解构声明~~~~~~~~~~~~~~~~~~~~")
        //组件函数允许数据类在解构声明中使用：
        val jane = User2("Jane", 35)
        val (name, age) = jane
        println("$name, $age years of age") // prints "Jane, 35 years of age"


        println("Kotlin 泛型~~~~~~~~~~~~~~~~~~~~")
       /* 泛型，即 "参数化类型"，将类型参数化，可以用在类，接口，方法上。
        与 Java 一样，Kotlin 也提供泛型，为类型安全提供保证，消除类型强转的烦恼。*/

        //创建类的实例时我们需要指定类型参数:
        val box: Box<Int> = Box<Int>(1)
        // 或者
        val box2 = Box(1) // 编译器会进行类型推断，1 类型 Int，所以编译器知道我们说的是 Box<Int>。


        var boxInt = Box<Int>(10)
        var boxString = Box<String>("Runoob")

        println(boxInt.value)
        println(boxString.value)


        // 以下都是合法语句
        val box4 = boxIn<Int>(1)
        val box5 = boxIn(1)     // 编译器会进行类型推断


        val age1 = 23
        val name1 = "runoob"
        val bool1 = true

        doPrintln(age1)    // 整型
        doPrintln(name1)   // 字符串
        doPrintln(bool1)   // 布尔型

    }
    //定义泛型类型变量，可以完整地写明类型参数，如果编译器可以自动推定类型参数，也可以省略类型参数。
    //Kotlin 泛型函数的声明与 Java 相同，类型参数要放在函数名的前面：
    fun <T> boxIn(value: T) = Box(value)

    //在调用泛型函数时，如果可以推断出类型参数，可以省略泛型参数。
    //函数根据传入的不同类型做相应处理：
    fun <T> doPrintln(content: T) {

        when (content) {
            is Int -> println("整型数字为 $content")
            is String -> println("字符串转换为大写：${content.toUpperCase()}")
            else -> println("T 不是整型，也不是字符串")
        }
    }

}