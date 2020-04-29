package com.example.kotlin.designpatterns.observer

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.designpatterns.decorator.candy.*
import com.example.kotlin.designpatterns.decorator.dec.MilkDarkRoast
import com.example.kotlin.designpatterns.observer.obs.NewsClient
import com.example.kotlin.designpatterns.observer.obs.NewsData
import com.example.kotlin.designpatterns.observer.obs.PadNewsClient
import com.example.kotlin.designpatterns.observer.obs.PhoneNewsClient
import kotlinx.android.synthetic.main.activity_ktx.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

/*


   观察者模式

   观察者模式即被观察者的状态发生变化时，观察者可以及时观察到并作出响应。被观察者可以添加和移除观察者

 */
class ObserverActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ktx)


        //一个新闻站在收到新的新闻后，需要及时在手机端和pad端显示。  新闻:被观察者

        val phoneClient: NewsClient = PhoneNewsClient()
        phoneClient.clientName = "phone news client"

        val padClient: NewsClient = PadNewsClient()
        padClient.clientName = "pad news client"

        val newsData = NewsData()
        newsData.registerObserver(padClient)
        newsData.registerObserver(phoneClient)

        newsData.receiveNews(System.currentTimeMillis(), "news0", "content0")

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                newsData.receiveNews(System.currentTimeMillis(), "new1", "content1")
                timer.cancel()
            }
        }, 2000)
    }
}