package com.example.kotlin.designpatterns.observer.obs

//观察者
//被观察者定义好后，接下来看观察者，对于观察者，这里只定义一个update方法，表示被观察者状态变化时通知观察者并执行更新操作
interface Observer {
    fun update(time: Long, title: String, content: String)
}