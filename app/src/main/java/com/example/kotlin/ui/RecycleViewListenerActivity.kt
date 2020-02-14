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
//    private lateinit var adapter: RVListenerAdapter
    private lateinit var adapter: TestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycleview)


        initView()

        initData()

    }

    fun initView() {

        recycler_view.layoutManager = LinearLayoutManager(this)

//        adapter = RVListenerAdapter(this, data)
//
//        recycler_view.adapter = adapter
//
//        adapter.setMyListener {_,position ->
//           Toast.makeText(this@RecycleViewListenerActivity,data.get(position),Toast.LENGTH_SHORT).show()
//        }



        adapter = TestAdapter(this, data)

        recycler_view.adapter = adapter

        adapter.setOnItemClickListener { position, item ->
//            Toast.makeText(this@RecycleViewListenerActivity,data.get(position),Toast.LENGTH_SHORT).show()
            Toast.makeText(this@RecycleViewListenerActivity,item,Toast.LENGTH_SHORT).show()
        }

    }

    private fun initData() {

        data.apply {
            add("a")
            add("b")
            add("c")
            add("d")
            add("e")
            add("f")
            add("g")
            add("h")
            add("i")
            add("j")
            add("k")
            add("l")
            add("m")
            add("n")
            add("o")
            add("p")
            add("q")
        }


        adapter.notifyDataSetChanged()


    }


}