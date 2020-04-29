package com.example.kotlin.designpatterns.observer.obs

interface ShowNewsInterface {
    fun show(time: Long, title: String, content: String)
}