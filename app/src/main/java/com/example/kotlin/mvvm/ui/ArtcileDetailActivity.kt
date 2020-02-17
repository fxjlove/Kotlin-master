package com.example.kotlin.mvvm.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.mvvm.viewmodel.ArticleDetailViewModel

/**
 * 页面描述：ArticleDetailActivity,处理和用户的交互（点击事件），以及处理
 * viewModel层回调的数据,附加一些显示Loading,空状态和绑定生命周期等等的操作
 */
class ArtcileDetailActivity: AppCompatActivity() {
    lateinit var viewModel: ArticleDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.article_detail_activity)
    }
}