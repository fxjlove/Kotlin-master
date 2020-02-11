package com.example.kotlin.common

//全局公共参数
//https://www.jianshu.com/p/e8752c880088
class Conant {
    /*
    java

    常量

     class StaticDemoActivity {
         public static final String LOAN_TYPE = "loanType";
         public static final String LOAN_TITLE = "loanTitle";
    }
    */

    /*const的使用

    const 必须修饰val
    const 只允许在top-level级别和object中声明，


    const val 和val修饰对象的主要区别是：
    const val 可见性为public final static，可以直接访问。
    val 可见性为private final static，并且val 会生成方法getNormalObject()，通过方法调用访问。

    当定义常量时，出于效率考虑，我们应该使用const val方式，避免频繁函数调用。


    注：const 关键字用来修饰常量，且只能修饰  val，不能修饰var,  companion object 的名字可以省略，可以使用 Companion来指代

    */


   /* companion object {
        val  LOAN_TYPE = "loanType"
        val  LOAN_TITLE = "loanTitle"
    }
    */

    //或者

/*    companion object StaticParams{
        val  LOAN_TYPE = "loanType"
        val  LOAN_TITLE = "loanTitle"

        //静态方法
        fun test(){

        }
    }*/

    //或者

    companion object {
        //常量
        const val LOAN_TYPE = "loanType"
        const val LOAN_TITLE = "loanTitle"

        /** 标题类型*/
        const val ITEM_TYPE_TITLE = 0
        /** 内容*/
        const val ITEM_TYPE_CONTEXT = 1

        //静态方法
        fun test(){

        }
    }


    //companion object {}中用来修饰 静态常量，或者静态方法，单例等等



}