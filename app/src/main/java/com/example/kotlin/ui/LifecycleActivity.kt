package com.example.kotlin.ui

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.kotlin.R
/*

Lifecycle 是一个持有组件生命周期信息的类，并允许其他对象观察此状态

生命周期使用两个主要枚举来跟踪其关联组件的生命周期状态

Event - 从框架和Lifecycle 类派发的生命周期事件， 这些事件映射到activity 和fragment 中的回调事件

State - 由 Lifecycle 对象跟踪的组件的当前状态
*/

class LifecycleActivity : AppCompatActivity(),LifecycleOwner {

    //创建LifecycleRegistry，如果实现了已经实现了LifecycleOwner 接口，并返回lifecycleRegistry
    private lateinit var lifecycleRegistry: LifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
    }

    public override fun onStart() {
        super.onStart()
        lifecycleRegistry.markState(Lifecycle.State.STARTED)
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }
}
