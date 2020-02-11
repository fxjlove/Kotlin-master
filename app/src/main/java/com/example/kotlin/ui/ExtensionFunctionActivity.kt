package com.example.kotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_extension_function.*
import kotlinx.android.synthetic.main.activity_extension_function.et_01
import org.jetbrains.anko.toast

/**
 * 扩展函数与高阶函数-实际应用
 */
class ExtensionFunctionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension_function)

        /*

        当任意一个输入框为空时“注册”按钮为不可用状态。


        场景分析
        首先需要监听所有输入框的输入变化
        其次需要判断所有输入框是否都不为空
        最后根据判断设置“注册”按钮状态

        根据我们的分析按照传统方式我们需要同时给4个输入框添加TextWatcher并且每个都需要判断其它几个输入框是否为空再来设置按钮。

        但是我们使用的是kotlin既然最终改变的是按钮的状态那我们就可以给按钮扩展一个方法来设置它的状态设置的依据通过扩展方法的参数传入高阶函数。

       */


        //使用扩展方法
        btn.enable(et_01,{isBtnEnable()})
        btn.enable(et_02,{isBtnEnable()})
        btn.enable(et_03,{isBtnEnable()})
        btn.enable(et_04,{isBtnEnable()})


        btn.setOnClickListener{
            toast("注册")
        }

    }

    /*

    扩展方法代码

     Button扩展了一个方法enable
     第一个参数EditText因为需要监听它的变化
     第二个参数是方法,方法的作用就是判断是否所有输入框都不为空返回值是Boolean
     在EditText监听中动态设置按钮是否可用
 */
    fun Button.enable(et: EditText, method: () -> Boolean) {
        val btn = this
        et.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btn.isEnabled = method()
            }
        })

    }
    //判断方法代码  所有输入框都不为空时返回true否则返回false
    private fun isBtnEnable(): Boolean{
        return et_01.text.isNotEmpty()&&et_02.text.isNotEmpty()&&et_03.text.isNotEmpty()&& et_04.text.isNotEmpty();
    }
}