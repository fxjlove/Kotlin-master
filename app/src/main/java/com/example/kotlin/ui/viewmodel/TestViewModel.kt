package com.example.kotlin.ui.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/*
LiveData的创建基本会在ViewModel中，从而使数据在界面销毁时继续保持
创建一个LiveData实例来保存某种类型的数据
确保存储LiveData对象是在ViewModel中而不 是Activity 或 Fragment 中*/
class TestViewModel : ViewModel() {

    var mCurrent: MutableLiveData<String>? = null
        get() {
            if (field == null) {
                field = MutableLiveData()
            }
            return field
        }
}