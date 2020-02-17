package com.example.kotlin.ui

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import com.example.kotlin.interf.MyLifecyckleCallback
/*
使用 OnLifecycleEvent 标记每个执行方法的Event
当活动状态改变时，系统会判断即将要改变成的状态
根据状态获取要执行的Event
从注册的Observer中获取标注为对应的Event，执行逻辑

*/
class MyObserver(var lifecycle: Lifecycle, var myLifecyckleCallback: MyLifecyckleCallback) :
    LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public fun connectOnCreate() {
        println("OnCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public fun connectOnResume() {
        println("OnResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public fun connectOnStart() {
        println("OnStart")
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public fun connectOnDestory() {
        println("OnDestory")
    }

    fun println(string: String) {
        myLifecyckleCallback.update(string)
    }
}