package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.kotlin.RVAdapter.OnItemClickLitener
import kotlinx.android.synthetic.main.activity_recycleview.*
import org.jetbrains.anko.toast
import java.util.LinkedHashMap

/**
 * RecycleView 列表
 */
class RecycleViewActivity : AppCompatActivity() {


    var data = ArrayList<String>()

    var data2 = mutableListOf<String>()

    val mutableMapOf = mutableMapOf<String, Int>()

    val mutableMapOf2 = HashMap<String, String>()

    val mutableMapOf3 = LinkedHashMap<String, String>()

//    var myadapter  = RVAdapter(this,mutableMapOf,data)

//    private lateinit var adapter : RVAdapter

    private lateinit var adapter: RVAdapter

//    lateinit var adapter: AriticleAdapter



    var mDataList: MutableList<String> = mutableListOf()
    var fragments: MutableList<String> = mutableListOf()
//    internal var pagerAdapter: ViewPagerAdapter? = null
//    lateinit var loadsir: LoadService<Any>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycleview)


        initView()

        initData()

    }
    fun initView(){

//        recycler_view.setLayoutManager(LinearLayoutManager(this))
        recycler_view.layoutManager = LinearLayoutManager(this)
//        var manager : LinearLayoutManager = LinearLayoutManager(this)
//        recycler_view.layoutManager = manager

//        myadapter = RVAdapter(this,mutableMapOf,data)
//        recycler_view.adapter = myadapter

//        recycler_view.adapter = RVAdapter(this,mutableMapOf,data)



        adapter = RVAdapter(this,mutableMapOf,data, object : OnItemClickLitener {
            override fun onItemClick(view: View, position: Int) {
                toast(data.get(position))
            }
        })

        recycler_view.adapter = adapter

    }
    fun initData(){
        //创建可变集合
//        val mutableMapOf = mutableMapOf<String, Int>()
        mutableMapOf.put("a",1)
        mutableMapOf.put("b",2)
        mutableMapOf.put("c",3)
        mutableMapOf.put("d",4)
        mutableMapOf.put("f",4)
        mutableMapOf.put("g",4)
        mutableMapOf.put("h",4)
        mutableMapOf.put("i",4)
        mutableMapOf.put("j",4)
        mutableMapOf.put("k",4)
        mutableMapOf.put("l",4)
        mutableMapOf.put("m",4)
        mutableMapOf.put("n",4)

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

//        var  myadapter = RVAdapter(this,mutableMapOf,data)
//
//        recycler_view.adapter = myadapter

//        myadapter.notifyDataSetChanged()


//        recycler_view.adapter?.notifyDataSetChanged()

        adapter.notifyDataSetChanged()


    }


}