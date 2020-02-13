package com.example.kotlin.widget

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.example.kotlin.R

//internal 声明，在同一模块中的任何地方可见
class CustomDialog2(context: Context, view: View, size: Double) : Dialog(context, R.style.AlertDialogStyle) {
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

}

