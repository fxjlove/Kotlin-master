package com.example.kotlin.single

import android.content.Context

class SingletonDemo2 private constructor() {
    companion object {
        //双重校验锁式
        val instance: SingletonDemo2 by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SingletonDemo2()
        }
    }
}
