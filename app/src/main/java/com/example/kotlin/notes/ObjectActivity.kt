package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.example.kotlin.applybean.Resp
import com.example.kotlin.applybean.User
import com.example.kotlin.applybean.User2
import com.example.kotlin.applybean.User3
import com.example.kotlin.common.TopLevelClass
import kotlinx.android.synthetic.main.activity_apply.*
import org.jetbrains.anko.toast
import java.util.*

/**
 * object 与companion object的区别
 */
class ObjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)


        objectT()



        TopLevelClass.doSomeStuff()
        TopLevelClass.Companion.doSomeStuff()
        TopLevelClass.FakeCompanion.doOtherStuff()

    }
    //object关键字
    private fun objectT(){

        //object 关键字可以表达两种含义：一种是对象表达式,另一种是 对象声明。

        //1.对象表达式

        //继承一个匿名对象

        //OnClickListener 事件是一个匿名类的对象，用object来修饰
        tv_01.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(this@ObjectActivity, "点击事件生效", Toast.LENGTH_LONG)
            }

        })

       // 2、对象声明

        //（用object 修饰的类为静态类，里面的方法和变量都为静态的。）有问题        （object 修饰的类是单例类）
        DemoManager.MyObject.a()
    }




}

//2.1 直接声明类
object DemoManager {
    private val TAG = "DemoManager"

    fun a() {
        Log.e(TAG,"此时 object 表示 声明静态内部类")
    }

    //2.2 声明静态内部类  类内部的对象声明，没有被inner 修饰的内部类都是静态的
    object MyObject {
        fun a() {
            Log.e(TAG,"此时 object 表示 直接声明类")
        }
    }



}

class Manager{
//    private val MY_TAG = "DemoManager"
    //companion object 修饰为伴生对象,伴生对象在类中只能存在一个，类似于java中的静态方法 Java 中使用类访问静态成员，静态方法。
    companion object {
        private val TAG = "DemoManager"
        private val MY_TAG = "DemoManager"
        fun b() {
            Log.e(TAG,"此时 companion objec t表示 伴生对象")
            Log.e(MY_TAG,"此时 companion objec t表示 伴生对象")
        }
    }

    //kotlin 中调用
    fun init(){
        b()
    }
}
