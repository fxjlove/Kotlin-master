package com.example.kotlin.inherit

import android.content.Context
import android.util.AttributeSet

open class View {
    //从构造方法  从构造方法使用constructor关键字引出
    constructor(ctx: Context){
        //some code
    }
    constructor(ctx: Context,attr: AttributeSet){
        //some code
    }
}