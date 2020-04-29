package com.example.kotlin.designpatterns.decorator

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.designpatterns.decorator.candy.*
import com.example.kotlin.designpatterns.decorator.dec.MilkDarkRoast
import kotlinx.android.synthetic.main.activity_ktx.*
import kotlinx.android.synthetic.main.activity_main.*

/*


   Kotlin设计模式实现之装饰者模式（Decorator）


  装饰者模式（Decorator）：在不改变对象自身的基础上，动态地给一个对象添加一些额外的职责。与继承相比，装饰者是一种更轻便灵活的做法。若要扩展功能，装饰者提供了比继承更有弹性的替代方法。


 */
class DecoratorActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ktx)

       //卖咖啡的系统，有不同种类的咖啡，需要能计算出咖啡的钱和区分咖啡的类别。


        //装饰者模式
        var beverage2 : Beverage = DarkRoast()
        beverage2 = Mocha(beverage2)
        beverage2 = Mocha(beverage2)
        beverage2 = Whip(beverage2)
        println(beverage2.getDescriptions()+beverage2.cost())


        var beverage = DarkRoast()
        var milkDarkRoast = MilkDarkRoast()

        println(beverage.getDescriptions()+" "+beverage.cost())

        println("~~~~~~~~~~~~~~~~~~~~")


        var chocolateCandy: Candy = ChocolateCandy()
        chocolateCandy = BlueBox(chocolateCandy)
        println(chocolateCandy.getCandyName() + " ￥" + chocolateCandy.cost())

        var milkCandy: Candy = MilkCandy()
        milkCandy = RedBox(milkCandy)
        println(milkCandy.getCandyName() + " ￥" + milkCandy.cost())
    }
}