package com.example.kotlin.util

import android.content.Context
import android.preference.PreferenceManager

/**
 * kotlin的工具类该怎么写
 * Object
 *   用于生成单例
 *  在init{}
 *   中完成单例的初始化
 *   注意：对象声明不能在局部作用域（即直接嵌套在函数内部），但是它们可以嵌套到其他对象声明或非内部类中。
 */
object SettingUtil {
    /**
     * 设置主题颜色
     */
    fun setColor(context: Context, color: Int) {
        val setting = PreferenceManager.getDefaultSharedPreferences(context)
        setting.edit().putInt("color", color).apply()
    }

}