package com.example.kotlin.notes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_other.*

/**
 * 点击
 */
class ClickActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        tv_01.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                //啊！我被点击了
            }
        })


        tv_01.setOnClickListener { v ->
            {
                //啊！我被点击了
            }
        }


        tv_01.setOnClickListener {
            //啊！我被点击了
        }




    }


}