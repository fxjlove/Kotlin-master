package com.example.kotlin

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
//作用:添加了这一行后我们就不需要再findViewById就可以了，
import android.util.Log


/**
 * 基础语法
 */
class BasicGrammarActivity : AppCompatActivity(){

//    var <标识符> : <类型> = <初始化值>
    //为TextView控件赋值

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)



        var result =  sum(1,2);
//        println("result:"+result);
        Log.e("result1",result.toString());

        Log.e("result3",sum(3,3).toString());

        printSum(4,4);
        printSum2(5,5);
        printSum3(6,6);



        vars(1,2,3,4);


        stringTemplate()

        nullMechanism()

        typeCheck()

        ifFunction()

    }

    //函数定义使用关键字 fun，参数格式为：参数 : 类型
    fun sum(a: Int, b: Int): Int {   // Int 参数，返回值 Int
        return a + b
    }

    fun sum2(a: Int,b: Int): Int{
        return a+b;
    }

    //表达式作为函数体，返回类型自动推断：
    fun sum3(a: Int, b: Int) = a + b

    //无返回值的函数(类似Java中的void)：
    fun printSum(a: Int, b: Int): Unit {
        print(a + b)
        Log.e("result4",(a+b).toString());
    }

    // 如果是返回 Unit类型，则可以省略(对于public方法也是这样)：
    fun printSum2(a: Int, b: Int) {
        print(a + b)
        Log.e("result5",(a+b).toString());
    }

    // 如果是返回 Unit类型，则可以省略(对于public方法也是这样)：
    public fun printSum3(a: Int, b: Int) {
        print(a + b)
        Log.e("result6",(a+b).toString());
    }

    //函数的变长参数可以用 vararg 关键字进行标识：
    fun vars(vararg v:Int){
        for(vt in v){
            print(vt)
            Log.e("result7",vt.toString());
        }
    }
    // 测试
    fun main(args: Array<String>) {
        vars(1,2,3,4,5)  // 输出12345

        val sumLambda: (Int, Int) -> Int = {x,y -> x+y}
        println(sumLambda(1,2))  // 输出 3
    }

    //TODO 字符串模板
    fun stringTemplate(){
        /*
        $ 表示一个变量名或者变量值
        $varName 表示变量值
        ${varName.fun()} 表示变量的方法返回值:
      */

        Log.e("result","字符串模板~~~~~~~~~~~~~~")
        var a = 1
        // 模板中的简单名称：
        val s1 = "a is $a"
        Log.e("result","s1:"+s1)

        a = 2
        // 模板中的任意表达式：
        val s2 = "${s1.replace("is", "was")}, but now is $a"
        Log.e("result","s2:"+s2)

        val s3 = "${a}"
        Log.e("result","s3:"+s3)



        val s = "runoob"
        val str = "$s.length is ${s.length}" // 求值结果为 "runoob.length is 6"
        println(str)


        val price = """
    ${'$'}9.99
    """
        println(price)  // 求值结果为 $9.99
        Log.e("result","price:"+price)

    }

    //NULL检查机制
    fun nullMechanism(){
        Log.e("result","NULL检查机制~~~~~~~~~~~~~~")
        //类型后面加?表示可为空
        var age: String? = "23"
        Log.e("result","age:"+age)

        //抛出空指针异常
        val ages = age!!.toInt()
        Log.e("result","ages:"+ages)

        //不做处理返回 null
        val ages1 = age?.toInt()
        Log.e("result","ages1:"+ages1)

        //age为空返回-1
        val ages2 = age?.toInt() ?: -1
        Log.e("result","ages2:"+ages2)
    }
    //类型检测及自动类型转换 和 区间
    fun typeCheck(){
        Log.e("result","类型检测及自动类型转换~~~~~~~~~~~~~~")
        //我们可以使用 is 运算符检测一个表达式是否某类型的一个实例(类似于Java中的instanceof关键字)。


        //区间
        for (i in 1 until 4) {   // i in [1, 4) 排除了 4
            print(i)
            Log.e("result","区间:"+i)
        }


    }
    fun ifFunction(){
        Log.e("result","IF 表达式~~~~~~~~~~~~~~")
        // 作为表达式
//        val max = if (1 > 2) 1 else 2

        val max = if (1 > 2) {
            print("Choose a")
            1
        } else {
            print("Choose b")
            2
        }
        Log.e("result","max:"+max)
    }
    /**
     *
     * is  in
     *
     *  is 运算符检测一个表达式是否某类型的一个实例(类似于Java中的instanceof关键字)。
     *
     *  if (obj is String) {
     *  }
     *
     *   in 运算符来判断集合内是否包含某实例：
     */

}