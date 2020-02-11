package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * 高阶函数  https://www.jianshu.com/p/7a771317ab74
 */
class HigherOrderFunctionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        println("高阶函数~~~~~~~~~~~~~~~~~~~~~~")
        /*
            高阶函数就是以另一个函数作为参数或返回值的函数，Kotlin可以以lambda或参数引用作为参数或返回值，所以，任何以lambda或函数引用作为参数或返回值的都是高阶函数

        */

        //函数类型
//        val sum = { x: Int, y: Int -> x + y }

        //之所以能这么写得益于Kotlin的类型推导，它的显示写法是这样的：
        var sum:(Int,Int)-> Int = {x , y-> x + y}
        //(Int,Int)是参数类型，->后面的值Int是返回类型,组合在一起就构成了一个函数类型,以上属于有参有返回值类型

        var action:() ->Unit = {} //无参无返回值
        var a = {} //类型推导后的简化写法
        var action1:(Int) ->Unit = {} //有参无返回值
//        var action2:() -> Int = {} //无参有返回值



        //todo 使用高阶函数
        //将函数类型作为参数

        //调用
        var value = getNumResult{ a, b -> a + b }
        //==> value = 3

        var value2 = getNumResult{ a, b -> a * b }
       // ==> value2 = 2


        
        //将函数类型作为返回值

        //使用:
        var ride = getNum(1) //传递一个1进去代表使用乘法
        var result2 = ride(Num(3)) //得到一个以Num作为参数的高阶函数
        //==> result2 = 9

        var sum2 = getNum(2)
        var result = sum2(Num(3))
        //==> result = 6


        higherOrderFunctions()

        customHigherOrderFunctions();
    }
    //将函数类型作为参数
    fun getNumResult(result: (Int, Int) -> Int): Int {
        return result(1,2)
    }

    //将函数类型作为返回值
    //定义一个类用于装载参数
    class Num(var num: Int)
    //此方法的作用是如果type等于1，那么就从Num类中取出num进行乘法操作，如果不等于一，就进行相加操作
    fun getNum(type: Int): (Num) -> Int {
        if (type == 1) {
            //这是一种写法
            return { entity ->
                entity.num * entity.num
            }
        } else {
            //这是另一种简写，可以用it代替entity参数
            return {
                it.num + it.num
            }
        }

        val url ="http://kotl.in"
        performRequest(url){
            code, content ->  /*...*/
        }
        performRequest(url){
            code, page ->  /*...*/
        }


        twoAndThree{a,b -> a+b}
        twoAndThree{a,b -> a*b}

    }
    //高阶函数
    fun higherOrderFunctions(){
        println("高阶函数2~~~~~~~~~~~~~~~")
        /*

            声明函数类型：

           （Int, String）-> Unit

           （Int, String）参数类型

            Unit    返回类型



                接受者类型String          作为参数传递的函数的参数类型(Chat)
            fun String,filter(predicate: (Chat) -> Boolean): String
                              参数类型predicate     作为参数传递的函数的返回类型Boolean



            (Chat) -> Boolean 函数类型参数
        */

        val url ="http://kotl.in"
        performRequest(url){
                code, content ->  /*...*/
        }
        performRequest(url){
                code, page ->  /*...*/
        }


        //将函数类型作为参数
        twoAndThree{a,b -> a+b}
        twoAndThree{a,b -> a*b}
    }

    //函数类型的参数名：可以为函数类型声明中的参数指定名称
     fun performRequest(url: String,callback:(code: Int, content: String) -> Unit){
         /*...*/
     }


    //定义一个函数类型的参数
    fun twoAndThree(operation: (Int, Int) -> Int){
        //调用函数类型的参数
        val result = operation(2,3)
        println("The result is $result")
    }

    //todo 自定义高阶函数
    fun customHigherOrderFunctions(){
        println("自定义高阶函数~~~~~~~~~~~~~~~")


        // 调用
        var a = test(10,sum(3,5)) // 结果为：18
        println(a)

        // 调用
        var b = test(10,{ num1: Int, num2: Int ->  num1 + num2 })  // 结果为：18
        println(b)


         //传入两个参数，并传入一个函数来实现他们不同的逻辑
        val result1 = resultByOpt(1,2){
                num1, num2 ->  num1 + num2
        }

        val result2 = resultByOpt(3,4){
                num1, num2 ->  num1 - num2
        }

        val result3 = resultByOpt(5,6){
                num1, num2 ->  num1 * num2
        }

        val result4 = resultByOpt(6,3){
                num1, num2 ->  num1 / num2
        }

        println("result1 = $result1")
        println("result2 = $result2")
        println("result3 = $result3")
        println("result4 = $result4")
        //这个例子是根据传入不同的Lambda表达式，实现了两个数的+、-、*、/。
        //当然了，在实际的项目开发中，自己去定义高阶函数的实现是很少了，因为用系统给我们提供的高阶函数已经够用了。不过，当我们掌握了Lambda语法以及怎么去定义高阶函数的用法后。在实际开发中有了这种需求的时候也难不倒我们了。


    }


    // 源代码
    fun test(a : Int , b : Int) : Int{
        return a + b
    }

    fun sum(num1 : Int , num2 : Int) : Int{
        return num1 + num2
    }




    // lambda
    fun test(a : Int , b : (num1 : Int , num2 : Int) -> Int) : Int{
        return a + b.invoke(3,5)
    }

    //传入两个参数，并传入一个函数来实现他们不同的逻辑
    private fun resultByOpt(num1 : Int , num2 : Int , result : (Int ,Int) -> Int) : Int{
        return result(num1,num2)
    }

}