package com.example.kotlin.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_other.*


/**
 * Glide
 */

class GlideActivity : AppCompatActivity() {
    private lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        Glide.with(this)
            .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574660386283&di=55125217ab36e97befc451afb730b194&imgtype=jpg&src=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D4197567677%2C2263710081%26fm%3D214%26gp%3D0.jpg")
            .into(iv)



    }


}