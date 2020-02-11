package com.example.kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_other.*
import org.jetbrains.anko.toast

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        initData()

        tv_01.setOnClickListener() {
            var intent = Intent()
            intent.putExtra("name", "啦啦啦")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }


    }
    fun initData(){
        val bundle = this.intent.extras
        val name = bundle.getString("name")
        val age = bundle.getInt("age",0)
        tv_01.text = "收到请求消息：\n请求姓名为${name}\n请求年龄为${age}"
        toast("名字："+name+"  age:"+age)
    }
}