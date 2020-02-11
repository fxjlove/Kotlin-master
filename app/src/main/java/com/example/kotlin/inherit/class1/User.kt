package com.example.kotlin.inherit.class1

class User(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""Address was changed for $name:"$field"->"$value".""".trimIndent())//读取支持字段的值
            field = value//更新支持字段的值

        }
}