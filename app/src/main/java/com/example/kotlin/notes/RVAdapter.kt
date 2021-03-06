package com.example.kotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class RVAdapter(mContext: Context,mutableMap: MutableMap<String, Int>,data:ArrayList<String>,onItemClickLitener: OnItemClickLitener) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
//    var data = ArrayList<String>()
    private  var data = data
    private  var mContext  = mContext
    private  var mOnItemClickLitener = onItemClickLitener

//    private var list: ArrayList<String>? = null
//    private var context: Context? = null
//    private var mOnItemClickLitener: OnItemClickLitener? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val inflate = LayoutInflater.from(mContext).inflate(R.layout.recycleview_item,p0, false)
        var holder: RecyclerView.ViewHolder = ViewHolder(inflate)
        return holder
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.tv.setText(data.get(position).toString())

        // 点击事件
        viewHolder.itemView.setOnClickListener {
            mOnItemClickLitener!!.onItemClick(it,position)
        }
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv : TextView = itemView.findViewById(R.id.tv)
    }

    //自定义接口
    interface OnItemClickLitener {
        //RecyclerView列表点击
        fun onItemClick(view: View, position: Int)
    }

}