package com.example.kotlin.designpatterns.observer.obs

import java.util.*
//被观察者
//我们遵循面向接口编程的设计思想，首先先来定义被观察者的主题，被观察者主要有添加观察者、删除观察者和通知观察者三个基础功能，那么我们先来定义Subject接口
interface Subject {
    fun registerObserver(observer: Observer);
    fun removeObserver(observer: Observer);
    fun notifyObserver();
}
