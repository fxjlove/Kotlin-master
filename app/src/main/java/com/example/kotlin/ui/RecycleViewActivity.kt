package com.example.kotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_recycleview.*
import org.jetbrains.anko.toast

/**
 * RecycleView 列表  RecycView的点击事件依照 java 的思想（不推荐）
 */
class RecycleViewActivity : AppCompatActivity() {

//    private var data: ArrayList<String>? = null
    private var data=ArrayList<String>()
    private var adapter: RVAdapter? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycleview)


        initView()

        initData()

    }
    fun initView(){

        recycler_view.layoutManager = LinearLayoutManager(this)

//        data = ArrayList()
        adapter = RVAdapter(this,data, object : RVAdapter.OnItemClickLitener {
            override fun onItemClick(view: View, position: Int) {
                toast(data.get(position))
            }
        })

        recycler_view.adapter = adapter

    }
    fun initData(){
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


        adapter?.notifyDataSetChanged()


    }


}