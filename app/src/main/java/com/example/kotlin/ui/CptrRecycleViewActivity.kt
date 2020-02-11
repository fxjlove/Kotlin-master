package com.example.kotlin.ui

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chanven.lib.cptr.PtrDefaultHandler
import com.chanven.lib.cptr.PtrFrameLayout
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF
import com.example.kotlin.R
import com.example.kotlin.cptr.CustomLoadMoreViewFooter
import com.example.kotlin.cptr.PtrClassicCustomHeader
import kotlinx.android.synthetic.main.activity_recycleview.recycler_view
import kotlinx.android.synthetic.main.activity_recycleview_cptr.*
import org.jetbrains.anko.toast

/**
 * 刷新、加载更多
 */
class CptrRecycleViewActivity : AppCompatActivity() {

    private var mContext: Context? = null
    private var data=ArrayList<String>()
    private var adapter: RVAdapter? = null

    /**
     * 刷新、分页加载
     */
    private var currentPage = 1 //当前页数
    private var totalPage = 0 //总页数
    private var mAdapterHF: RecyclerAdapterWithHF? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycleview_cptr)
        mContext = this

        initView()

        initData()

    }
    fun initView(){

        recycler_view.layoutManager = LinearLayoutManager(this)

        adapter = RVAdapter(this,data, object : RVAdapter.OnItemClickLitener {
            override fun onItemClick(view: View, position: Int) {
                toast(data.get(position))
            }
        })

//        recycler_view.adapter = adapter

        mAdapterHF = RecyclerAdapterWithHF(adapter)
        recycler_view.adapter = mAdapterHF


        //自定义PtrClassicFrameLayout头部
        val customHeader = PtrClassicCustomHeader(mContext)
        ptr_frame_layout.headerView = customHeader
        ptr_frame_layout.addPtrUIHandler(customHeader)
        ptr_frame_layout.setPtrHandler(object : PtrDefaultHandler() {
            override fun onRefreshBegin(frame: PtrFrameLayout) {

                ptr_frame_layout.autoRefresh(true)
                //下拉刷新
                currentPage = 1
                updatePtrLayoutState()
            }
        })
        //自定义PtrClassicFrameLayout底部
        val customFooter = CustomLoadMoreViewFooter()
        ptr_frame_layout.setFooterView(customFooter)
        ptr_frame_layout.setOnLoadMoreListener {
            //上拉加载更多
            currentPage++


            //延迟2s退出Dialog
            Handler().postDelayed({
                data.add("a~~~~~~~~~~~~~~")
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


                updatePtrLayoutState()
            }, 2000)

        }

    }
    /**
     * 更新下拉刷新控件状态
     */
    private fun updatePtrLayoutState() {
        if (ptr_frame_layout.isRefreshing()) {
            ptr_frame_layout.refreshComplete()
        }
        if (ptr_frame_layout.isLoadingMore()) {
            ptr_frame_layout.loadMoreComplete(true)
        }
//        if (totalPage == 0 || currentPage == totalPage) {
//            ptr_frame_layout.setLoadMoreEnable(false)
//        } else {
            ptr_frame_layout.setLoadMoreEnable(true)
//        }

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