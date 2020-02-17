package com.example.kotlin.ui

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleRegistry
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.kotlin.R
import com.example.kotlin.interf.MyLifecyckleCallback

//https://www.jianshu.com/p/0869bd273205
class MyLifeCycleActivity : AppCompatActivity() {

    private lateinit var lifecycleRegistry: LifecycleRegistry
    private lateinit var myObserver: MyObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //创建LifecycleRegistry，如果实现了已经实现了LifecycleOwner 接口，并返回lifecycleRegistry
        lifecycleRegistry = LifecycleRegistry(this)
        //在生命周期中设置相应的标记
        lifecycleRegistry.markState(Lifecycle.State.CREATED)

        //实例化创建MyObserver，绑定Lifecycles，并绑定 Lifecycle
        myObserver = MyObserver(lifecycleRegistry, object : MyLifecyckleCallback {
            override fun update(string: String) {
                Toast.makeText(this@MyLifeCycleActivity, string, Toast.LENGTH_SHORT).show()
            }
        })
        lifecycleRegistry.addObserver(myObserver)
    }

    override fun onStart() {
        super.onStart()
        lifecycleRegistry.markState(Lifecycle.State.STARTED)
    }

    override fun onResume() {
        super.onResume()
        lifecycleRegistry.markState(Lifecycle.State.RESUMED)
    }

    override fun onStop() {
        super.onStop()
        lifecycleRegistry.markState(Lifecycle.State.DESTROYED)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleRegistry.markState(Lifecycle.State.DESTROYED)
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }
}