package com.example.kotlin.single

import android.content.Context

class SingletonDemo private constructor(ctx: Context) {
    private var context: Context = ctx
    companion object {
        private var instance: SingletonDemo? = null
            get() {
                if (field == null) {
//                    field = SingletonDemo()
                }
                return field
            }
        fun get(ctx: Context): SingletonDemo{
            //细心的小伙伴肯定发现了，这里不用getInstance作为为方法名，是因为在伴生对象声明时，内部已有getInstance方法，所以只能取其他名字
            return instance!!
        }
    }
//
//    companion object {
//        val instance: SingletonDemo by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
//            SingletonDemo()
//        }
//    }
}
