package com.example.kotlin.interface1.inter2

class SubscribingUser(val email: String) : User{
    override val nickname: String
        get() = email.substringBefore('@') //自定义getter
}