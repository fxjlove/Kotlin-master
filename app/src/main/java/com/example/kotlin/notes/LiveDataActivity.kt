package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Lifecycle监听数据生命周期变化  LiveData生命周期感知组件  https://juejin.im/post/5b5ac0825188251acd0f3777
 */
class LiveDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

    }

}