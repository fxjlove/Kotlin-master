package com.example.kotlin.ui

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.*
import com.example.kotlin.R
import com.example.kotlin.widget.CustomDialog
import com.example.kotlin.widget.CustomDialog2
import kotlinx.android.synthetic.main.activity_dialog.*
import kotlinx.android.synthetic.main.view_dialog.*


class DialogActivity : AppCompatActivity() {
    private lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        mContext = this

        //https://www.jianshu.com/p/6829ae8b044f
        btn_01.setOnClickListener{
//            showDialog()
            showForwardDialog()
        }
/*

        根据lambda表达式规则@

        Lambda表达一般使用“{ }”包围。
        它的参数（如果有的话）在“->”前定义，参数类型可能是省略的。
        函数体跟在“->”后面。

*/

    }

    private fun showDialog() {
        val inflater = LayoutInflater.from(mContext)
        val view = inflater.inflate(R.layout.view_dialog, null)// 得到加载view
        val lLayout_bg = view.findViewById(R.id.lLayout_bg) as LinearLayout
        val tv_name = view.findViewById(R.id.tv_name) as TextView
        val tv_funName = view.findViewById(R.id.tv_funName) as TextView
        val et_content = view.findViewById(R.id.et_content) as EditText
        val btn_cancle = view.findViewById(R.id.btn_cancle) as Button
        val btn_send = view.findViewById(R.id.btn_send) as Button

        val dialog = AlertDialog.Builder(mContext, R.style.AlertDialogStyle).create()
        if (!dialog.isShowing) {
            dialog.show()
        }

        dialog.setContentView(view)
        dialog.setCancelable(false)

        //只用下面这一行弹出对话框时需要点击输入框才能弹出软键盘
        dialog.window!!.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)

        //调整dialog背景大小，要先创建dialog才能调整
        val windowManager = mContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        lLayout_bg.layoutParams =
            FrameLayout.LayoutParams((display.width * 0.85).toInt(), RelativeLayout.LayoutParams.WRAP_CONTENT)

        et_content.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(50))


        //取消
        btn_cancle.setOnClickListener {
            //                TCAgent.onEvent(context, TDEventID.CHAT_CUSTOMER_RECOMMEND_CANCEL);去除埋点
            dialog.dismiss()
        }
        //发送
        btn_send.setOnClickListener {
            dialog.dismiss()
        }


    }

    private fun showForwardDialog() {
        val view = LayoutInflater.from(mContext).inflate(R.layout.view_dialog, null)
        val btn_cancle = view.findViewById(R.id.btn_cancle) as Button
        val btn_send = view.findViewById(R.id.btn_send) as Button
//        val dialog = CustomDialog(mContext, view, R.style.AlertDialogStyle, 0.85)
        val dialog = CustomDialog2(mContext, view, 0.85)
        dialog.show()
        //取消
        btn_cancle.setOnClickListener {
            //                TCAgent.onEvent(context, TDEventID.CHAT_CUSTOMER_RECOMMEND_CANCEL);去除埋点
            dialog.dismiss()
        }
        //发送
        btn_send.setOnClickListener {
            dialog.dismiss()
        }
    }
}