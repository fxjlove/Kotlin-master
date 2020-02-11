package com. example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * Kotlin中?和!!的区别
 *
 * https://www.jianshu.com/p/51b2e5aa3dd8
 */
class NullActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

/*


        ? 表示当前对象可以为空，即可以 = null
        !! 表示当前对象不为空的情况下执行

*/

        /**
         * name 可以为空，即name = null；
         * 因为name有为空的可能性，所以people使用name时，需要在name后加!!，
         * 代表name不为空时执行代码，如果为空，仍会报错；
         */
        var name: String? = ""
        var people: String = name!!

        //一个小知识点,当列表为空时赋值0
        val nameList:MutableList<String>? = null
        val size = nameList?.size ?: 0


        val myList : ArrayList<String>? = null
        Log.d("TAG", "-->> List Size = ${myList?.size}")


        //roomList?.size!! > 0

        //当然Kotlin不会让程序出现这种啰嗦的代码，所以里面提供了对象A ?: 对象B表达式，并且取消了Java中的条件表达式 ? 表达式1 : 表达式2这个三元表达式。
        //对象A  ?:  对象B表达式
        val roomList: ArrayList<String>? = null
        val mySize= roomList?.size ?: 0

       //  ?: 表示的意思是，当对象A值为null的时候，那么它就会返回后面的对象B。


        //用 ? 和 ?: 基本上能避免程序中出现的所有NullPointerException。

/*

        //kotlin:
        a?.run()

        //与java相同:
        if(a!=null){
            a.run();
        }



        //kotlin:
        a!!.run()

        //与java相同:
        if(a!=null){
            a.run();
        }else{
            throw new KotlinNullPointException();
        }


        ?. 与 !!. 都是Kotlin提供的检测空指针的方法。

*/

        var name1 ="张三"
        var name2 ="张三"

        if (name1.equals(name2)){
            Log.e("fxj","相同")
        }else{
            Log.e("fxj","不相同")
        }

//        TextUtils.isEmpty(name1)



        //https://blog.csdn.net/SmileToLin/article/details/80894713

        var length_null:Int?
        val strB:String? = null
        // ?. 表示对象为空时就直接返回null，所以返回值的变量必须被声明为可空类型
        length_null = strB?.length         //打印null
        // ?: 表示为空时就返回右边的值
//        length_null = strB?.length ?: 0  //打印0

        Log.e("fxj","使用?.得到字符串B的长度为$length_null")



        var strC:String? = null
        var length:Int?
//        var strC = "排雷完毕"
//        var length = strC!!.length
//        Log.e("fxj","使用!!得到字符串B的长度为$length")

        //!!表示不做非空判断，强制执行后面的表达式，如果对象为空就会扔出空异常
        //所以只有在确保为非空时，才能使用!!
        try {
            //即使返回给可空变量length_null，也会扔出异常
            length = strB!!.length
            Log.e("fxj", "使用!!得到字符串B的长度为$length")
        } catch(e:Exception) {
            Log.e("fxj","发现空指针异常")
        }

/*
        总结一下，Kotlin引入了空安全的概念，并在编译时开展对象是否为空的校验。相关的操作符说明概括如下：

        1、声明对象实例时，在类型名称后面加问号，表示该对象可以为空；

        2、调用对象方法时，在实例名称后面加问号，表示一旦实例为空就返回null；

        3、新引入运算符“?:”，一旦实例为空就返回该运算符右边的表达式；

        4、新引入运算符“!!”，通知编译器不做非空校验，运行时一旦发现实例为空就扔出异常；

        */



//        TextUtils.isEmpty(strC)

/*
        isNullOrBlank函数进行空值校验，下面列出Kotlin校验字符串空值的几个方法：

        isNullOrEmpty : 为空指针或者字串长度为0时返回true，非空串与可空串均可调用。

        isNullOrBlank : 为空指针或者字串长度为0或者全为空格时返回true，非空串与可空串均可调用。

        isEmpty : 字串长度为0时返回true，只有非空串可调用。

        isBlank : 字串长度为0或者全为空格时返回true，只有非空串可调用。

        isNotEmpty : 字串长度大于0时返回true，只有非空串可调用。

        isNotBlank : 字串长度大于0且不是全空格串时返回true，只有非空串可调用。

        */


        //非空串
        //正常声明的对象默认都是非空（不可为null）
        var strNotNull:String = ""


        //可空串
        //非空对象要么在声明时就赋值，要么在方法调用前赋值；
        var strCanNull:String?


        //strC.isEmpty()
        if (strC != null) {
            strC.isEmpty()
        }

//        strC?.isEmpty()
//
//        strC!!.isEmpty()  报错



        test()
        nullType()
    }

     fun test(){

         //使用可能为null的实参调用strLen是不允许的，在编译期就会被标记成错误； ERROR:Null can not be a value of a non-null type String (Null不能是非空类型字符串的值)
//         strLen(null)

         strLenSafe(null)
    }

    /*java*/
//    private int strLen(String s){
//        return s.length();
//    }

    //表达式作为函数体，返回类型自动推断：
    fun  strLen(s: String) = s.length

    fun  strLen2(s: String?) = s?.length

    // Int 参数，返回值 Int
    fun  strLen3(s: String):Int{
        return s.length
    }

    public fun sum(a: Int, b: Int): Int = a + b   // public 方法则必须明确写出返回类型

    //增加了 null 检查后，这段地面就可以编译了
    fun strLenSafe(s: String?): Int =
            if (s != null) s.length else 0





    //todo 可空性
    fun nullType(){
        println("可空性~~~~~~~~~~~~~")
        /*

            1.安全调用运算符： ?.

                例如：  s?toUpperCase()  等同于  if(s != null) s.toUpperCase() else null

            安全调用运算符只会调用非空值的方法




            2.Elvis运算符(null合并运算符)： ?:


            Elvis运算符 经常和 安全调用运算符一起使用，用一个值带起对null对象调用方法时返回的null





            3.安全转换： as?

              安全转换运算符尝试把值转换成给定的类型，如果类型不合适就返回null

              一种常见的模式是把安全转换和Elvis运算符结合使用，例如，实现equals方法的时候这样的用法非常方便




            4.非空断言： !!

                 通过使用非空断言，如果值为null，可以显示地抛出异常




            5. let函数

                let函数让处理可空表达式变得更容易，和安全调用运算符一起，它允许你对表达式求值，检查求值结果是否为null,并把结果保存为一个变量

                可控参数最常见的一种用法应该就是被传递给一个接受非空参数的函数



            6.延迟初始化的属性  lateinit


            7.可空类型的扩展

                    isNullOrEmpty

                    isNullOrBlank

                    不需要安全调用就可以访问可空类型的扩展


       */

        //?.
        println(printAllCaps("abc"))
        println(printAllCaps(null))


        //?:
        foo("aa")

        println("let函数~~~~~~~~~~~~~")
        //let函数

        var email: String? = "yole@example.com"
        //必须显示地检查这个值不为null 或者 使用let函数，并通过安全调用来调用它
        if (email != null) {
//            email = "aa"
            sendEmailTo(email)
        }


        //let函数做的所有事情就是把一个调用它的对象变成lambda表达式的参数，如果结合安全调用法，它能有效地把调用let函数的可空对象，转变成非空类型
        /*
            foo?.let {
                it
            }

            foo != null 在lambda内部是非空的

            foot == null  什么都不会发生


                安全调用let只在表达式不为null时执行lambda


        */

//        email = "bb"
        //let函数只在email的值非空时才被调用，所有你就能在lambda中把email当作非空的实参使用
        email?.let { email -> sendEmailTo(email) }


//        email = "cc"
        //使用自动生成的名字it这种简明语法只会，上面的代码就更短了
        email?.let { sendEmailTo(it) }


        //如果email为null，则什么都不会打印
        email = null
        email?.let { sendEmailTo(it) }




        //可空类型的扩展
        verifyUserInput("  ")
        verifyUserInput(null)
        //都返回 Please fill in the required fields






       // ERROR:Type mismatch:inferred type is String! but Int was expected 类型不匹配:推断的类型是字符串!但是Int是预期的

    }

    //?.
     fun printAllCaps(s: String?){
         val allCaps: String? = s?.toUpperCase()
         println(allCaps)
     }

    //?:
    //如果 s 为 null，结果时一个空的字符串
    fun foo(s :String?){
        val t: String = s?:""
    }
    fun strLenSafe2(s: String?): Int = s?.length ?: 0


    //let函数
    fun sendEmailTo(email: String){
        println("Sending email to $email")
    }

    //可空类型的扩展
    fun verifyUserInput(input: String?){
        /*
            这个不需要安全调用

            isNullOrBlank 为空指针或者字串长度为0或者全为空格时返回true，非空串与可空串均可调用

            input 可控类型的值      isNullOrBlank()可空类型的扩展          input.isNullOrBlank() 不需要安全调用！

            不需要安全调用就可以访问可空类型的扩展

            函数isNullOrBlank显示地检查了null，这种情况下返回true,然后调用isBlank,它只能在非空String上调用

            isBlank : 字串长度为0或者全为空格时返回true，只有非空串可调用。


        */
        if(input.isNullOrBlank()){
            println("Please fill in the required fields")
        }
    }


    //todo 空类型安全
    fun empty(){
       // Kotlin引入了可空类型（用？标识），在编译期杜绝了可空类型直接调用方法的可能。

       /*

        var a: String = "abc"
        a = null // 编译错误

        var b: String? = "abc"
        b = null // ok

        val l = a.length

        val l = b.length // 错误：变量“b”可能为空
        val l = b?.length ?: 0

*/
    }

}

