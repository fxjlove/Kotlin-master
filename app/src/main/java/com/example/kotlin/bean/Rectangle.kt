package com.example.kotlin.bean

import java.util.*


class Rectangle(val height: Int,
                val width: Int) {
    //自定义访问器
    val isSquare: Boolean
        get(){
            return height == width
        }

    val isSquare2: Boolean
        get() = height == width

}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}