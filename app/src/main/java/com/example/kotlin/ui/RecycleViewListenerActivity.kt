package com.example.kotlin.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_recycleview.*
import org.jetbrains.anko.toast

/**
 * RecycView的点击事件Kotlin实现模式 自定义监听器
 */
class RecycleViewListenerActivity : AppCompatActivity() {

    private var data = ArrayList<String>()
    private lateinit var adapter: RVListenerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycleview)


        initView()

        initData()

    }

    fun initView() {

        recycler_view.layoutManager = LinearLayoutManager(this)

        adapter = RVListenerAdapter(this, data)

        recycler_view.adapter = adapter

        adapter.setMyListener {_,position ->
           Toast.makeText(this@RecycleViewListenerActivity,data.get(position),Toast.LENGTH_SHORT).show()
        }

    }

    fun initData() {
        data.add("a")
        data.add("b")
        data.add("c")
        data.add("d")
        data.add("e")
        data.add("f")
        data.add("g")
        data.add("h")
        data.add("i")
        data.add("j")
        data.add("k")
        data.add("l")
        data.add("m")
        data.add("n")
        data.add("o")
        data.add("p")
        data.add("q")


        adapter.notifyDataSetChanged()


    }


}