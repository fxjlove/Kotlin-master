package com.example.kotlin.inherit

import android.content.Context
import android.util.AttributeSet

class MyButton : View{
    //调用父类构造方法
    constructor(ctx: Context):super(ctx){
        //some code
    }
//    constructor(ctx: Context): this(ctx,MY_STYLE){
//
//    }

    constructor(ctx: Context, attr: AttributeSet):super(ctx){
        //some code
    }
}