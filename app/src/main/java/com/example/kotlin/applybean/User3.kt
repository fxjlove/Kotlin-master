package com.example.kotlin.applybean

class User3(var name: String, var age: Int, var phoneNum: String){
    override fun toString(): String {
        return "my name is $name, I am $age years old, my phone number is $phoneNum"
    }
}
