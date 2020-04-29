package com.example.kotlin.designpatterns.adapter

class Adapter(val wrapper: Adaptee) : Target {
    override fun request() {
        wrapper.setView()
    }
}