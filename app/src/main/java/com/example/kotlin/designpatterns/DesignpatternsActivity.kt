package com.example.kotlin.designpatterns

import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.designpatterns.builder.Student
import com.example.kotlin.designpatterns.data.Film
import kotlinx.android.synthetic.main.activity_designpatterns.*

/**
 * 设计模式 https://blog.csdn.net/heweigzf/article/details/98871046
 */
class DesignpatternsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_designpatterns)


        tv.setOnClickListener {
            build()
        }

        strategy()

    }
    /*
        1.建造者模式

        建造者模式是为了构建复杂而且多变的实例，Kotlin中使用apply函数实现
    */
    private fun build(){
        val dialog = Dialog(this).apply {
            setTitle("kotlin1111111")
            setCancelable(true)
            setCanceledOnTouchOutside(true)
//            show()
        }

        // usage
        val student = Student.build {
            model = "Heweii"
            year = 1993
        }
    }



    /*

        2.原型模式

        原型模式是以一个对象为原型，创建出一个新的对象。Kotlin因为使用 data class 时，会自动获得equals、hashCode、toString和copy方法，相对java简便很多，copy方法可以克隆整个对象并且允许修改新对象某些属性。

   */
    private fun prototype(){
        val film = Film("西游记", "。。。", "六小龄童。。。")
        val copy = film.copy(name = "西游记-后转")//copy方法可以克隆整个对象并且允许修改新对象某些属性
        println(film)
        println("````````````````")
        println(copy)
    }

   /*
     3.适配器模式
   */
    private fun adapter(){
       
   }
    /*
        4.装饰模式

        kotli中独有的扩展函数可以很简便的做到装饰模式
    */
    private fun decoration(){
        Text("Hello").run {
            underline {
                draw()
            }
        }
    }

    class Text(val text: String) {
        fun draw() = print(text)
    }

    fun Text.underline(decorated: Text.() -> Unit) {
        print("_")
        this.decorated()
        print("_")
    }

   /*

   8.策略模式

    定义一系列的算法,把它们一个个封装起来, 并且使它们可相互替换，kotlin可以使用高阶函数来实现

    */
    private fun strategy(){
       val studentDiscount = { fee: Double -> fee/2 }
       val noDiscount = { fee: Double -> fee }

       val student = Customer("Ned", 10.0, studentDiscount)
       val regular = Customer("John", 10.0, noDiscount)

       println(student.pricePerMonth())
       println(regular.fee)

   }
   class Customer(val name: String, val fee: Double, val discount: (Double) -> Double) {
       fun pricePerMonth() = discount(fee)
   }




}