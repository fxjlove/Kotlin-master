package com.example.kotlin.by.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.by.kotlin.attribute.AndroidDev
import com.example.kotlin.by.kotlin.attribute.ExtensionClass
import com.example.kotlin.by.kotlin.attribute.Jobs
import com.example.kotlin.by.kotlin.attribute.PhpDev
import com.example.kotlin.by.kotlin.classwt.DelegateClass
import com.example.kotlin.by.kotlin.classwt.Dog
import com.example.kotlin.by.kotlin.classwt.Human
import com.example.kotlin.by.kotlin.classwt.Pig

/*kotlin委托

委托模式是软件设计模式中的一项基本技巧。在委托模式中，有两个对象参与处理同一个请求，接受请求的对象将请求委托给另一个对象来处理。
Kotlin 直接支持委托模式，更加优雅，简洁。Kotlin 通过关键字 by 实现委托。


https://www.jianshu.com/p/a70ba6436e75/

https://www.cnblogs.com/nicolas2019/p/10998443.html
*/

class ByActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)


        commissionedByClass()
//        lazy()
    }

    //TODO 类委托
    /*
    类的委托即一个类中定义的方法实际是调用另一个类的对象的方法来实现的。
    以下实例中派生类 Derived 继承了接口 Base 所有方法，并且委托一个传入的 Base 类的对象来执行这些方法。
    */
    private fun commissionedByClass() {
        val b = BaseImpl(10)
        Derived(b).print() // 输出 10



        //​ 本类需要实现的方法/属性，借用其他已实现该方法/属性的对象作为自己的实现；
        //​ 一旦使用了某类作为委托类，该类就能借用该委托类实现的方法/属性。
        //作为形参（委托对象可复用）
        val delegateClass = DelegateClass()
        val human = Human(delegateClass)
        human.run()//结果：代理类执行run方法
        println(human.type)//结果：委托类该属性
        val human2 = Human(delegateClass)
        human2.run()//结果：代理类执行run方法
        println(human2.type)//结果：委托类该属性

        //新建对象
        val dog = Dog()
        dog.run()//结果：代理类执行run方法
        println(dog.type)//结果：委托类该属性

        //新建对象并自己实现方法/属性
        val pig = Pig()
        pig.run()//结果：自己执行实现的run方法
        println(pig.type)//结果：自己实现的type属性
    }

    //TODO 属性委托
    /*

    属性委托
    属性委托指的是一个类的某个属性值不是在类中直接进行定义，而是将其托付给一个代理类，从而实现对该类的属性统一管理。
    属性委托语法格式：
    val/var <属性名>: <类型> by <表达式>
    var/val：属性类型(可变/只读)
    属性名：属性名称
    类型：属性的数据类型
    表达式：委托代理类

    by 关键字之后的表达式就是委托, 属性的 get() 方法(以及set() 方法)将被委托给这个对象的 getValue() 和 setValue() 方法。属性委托不必实现任何接口, 但必须提供 getValue() 函数(对于 var属性,还需要 setValue() 函数)。
    定义一个被委托的类
    该类需要包含 getValue() 方法和 setValue() 方法，且参数 thisRef 为进行委托的类的对象，property 为进行委托的属性的对象。

*/
    private fun attributeToEntrust() {
        val e = Example()
        println(e.p)     // 访问该属性，调用 getValue() 函数

        e.p = "Runoob"   // 调用 setValue() 函数
        println(e.p)



        //属性委托：多个类的类似属性交给委托类统一实现，避免每个类都要单独重复实现一次。
        val androidDev = AndroidDev()
        androidDev.name = "android开发"
        println(androidDev.name)//结果：android开发
        val phpDev = PhpDev()
        println(phpDev.name)//结果：工作名
        println(ExtensionClass().name)//结果：工作名
    }

    /**
     * 为ExtensionClass扩展属性，该属性由委托类Jobs实现
     */
    val ExtensionClass.name by Jobs()


    //todo 标准委托
    private fun standardDelegation(){
        //Kotlin 的标准库中已经内置了很多工厂方法来实现属性的委托。

    }


    //todo 延迟属性 Lazy
    private fun lazy(){
        //lazy() 是一个函数, 接受一个 Lambda 表达式作为参数, 返回一个 Lazy <T> 实例的函数，返回的实例可以作为实现延迟属性的委托： 第一次调用 get() 会执行已传递给 lazy() 的 lamda 表达式并记录结果， 后续调用 get() 只是返回记录的结果。
        println(lazyValue)   // 第一次执行，执行两次输出表达式
        println("--------")
        println(lazyValue)   // 第二次执行，只输出返回值

    }
    val lazyValue: String by lazy {
        println("computed!")     // 第一次调用输出，第二次调用不执行
        "Hello"
    }




}
