package com.example.kotlin.widget

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.WindowManager


class CustomDialog(internal var context: Context, internal var view: View, style: Int, internal var size: Double) : Dialog(context, style) {
    init {
        setContentView(view)

        setCancelable(false)

        //只用下面这一行弹出对话框时需要点击输入框才能弹出软键盘
        window!!.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)

        //必须先show再调整宽高才有效
        val mWindowAttributes = window!!.attributes
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        mWindowAttributes.width = (windowManager.defaultDisplay.width * size).toInt()
        mWindowAttributes.height = WindowManager.LayoutParams.WRAP_CONTENT
        window!!.attributes = mWindowAttributes
    }
//    override fun onCreate(savedInstanceState: Bundle) {
//        super.onCreate(savedInstanceState)
//        //        View view = View.inflate(getContext(),R.layout.layout,null);
//        setContentView(view)
//
//        setCancelable(false)
//
//        //只用下面这一行弹出对话框时需要点击输入框才能弹出软键盘
//        window!!.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
//
//        //必须先show再调整宽高才有效
//        val mWindowAttributes = window!!.attributes
//        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
//        mWindowAttributes.width = (windowManager.defaultDisplay.width * size).toInt()
//        mWindowAttributes.height = WindowManager.LayoutParams.WRAP_CONTENT
//        window!!.attributes = mWindowAttributes
//
//    }


}

