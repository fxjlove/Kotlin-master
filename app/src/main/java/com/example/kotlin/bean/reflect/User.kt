package com.example.kotlin.bean.reflect

class User {
    var userName: String = "Czh11"
        get() = field
        set(value) {
            field = value
        }
}