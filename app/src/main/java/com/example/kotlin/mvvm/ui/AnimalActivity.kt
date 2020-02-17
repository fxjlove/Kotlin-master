package com.example.kotlin.mvvm.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.databinding.ActivityAnimalBinding
import com.example.kotlin.mvvm.model.Animal
import com.example.kotlin.mvvm.viewmodel.AnimalViewModel
import com.example.kotlin.mvvm.viewmodel.ArticleDetailViewModel

/**
 * 页面描述：ArticleDetailActivity,处理和用户的交互（点击事件），以及处理
 * viewModel层回调的数据,附加一些显示Loading,空状态和绑定生命周期等等的操作
 */
class AnimalActivity: AppCompatActivity() {
    lateinit var mBinding : ActivityAnimalBinding
    lateinit var mViewMode : AnimalViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= DataBindingUtil.setContentView(this,R.layout.activity_animal)
        //////model
        val animal= Animal("dog", 0)
        /////ViewModel
        mViewMode= AnimalViewModel(animal)
        ////binding
        mBinding.vm=mViewMode
    }
}