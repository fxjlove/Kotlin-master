package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import com.example.kotlin.applybean.Resp
import com.example.kotlin.applybean.User
import com.example.kotlin.applybean.User2
import com.example.kotlin.applybean.User3
import com.example.kotlin.single.SingletonDemo
import com.example.kotlin.single.SingletonDemo2
import kotlinx.android.synthetic.main.activity_apply.*
import org.jetbrains.anko.toast
import java.util.*

/**
 * Android之Kotlin：Kotlin的5种单例模式实现

徐哥EDU

关注

赞赏支持

 */
class SingletonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)


        SingletonDemo.get(this)

        SingletonDemo2.instance

    }

}