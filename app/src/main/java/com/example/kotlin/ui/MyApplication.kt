package com.example.kotlin.ui

import android.app.Application
import kotlin.properties.Delegates

class MyApplication : Application() {
    //创建一个Application，用于提供全局上下文
    companion object {

        var instance: MyApplication by Delegates.notNull()

        fun instance() = instance
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
    }

}
