package com.example.kotlin.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.kotlin.R
class TestAdapter(val context : Context , val data: List<String>) : RecyclerView.Adapter<TestAdapter.TestViewHolder>(){

    private var mListener : ((Int , String) -> Unit)? = null


    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.tv.text = data.get(position)
        holder?.itemView?.setOnClickListener {
            mListener?.invoke(position, data[position])
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
//        return TestViewHolder(View.inflate(context,R.layout.recycleview_item,parent))
        return TestViewHolder(LayoutInflater.from(context).inflate(R.layout.recycleview_item, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setOnItemClickListener(mListener : (position : Int, item : String) -> Unit){
        this.mListener = mListener
    }
/*
    inner关键字

    kotlin中支持类的嵌套（内部类），不过和java中不一样（java中包含一个指向外部类的对象的引用），kotlin中所有的内部类默认为静态的，这样很好的减少了内存泄漏问题。如果需要在内部类引用外部类的对象，可以使用inner声明内部类，使内部类变为非静态的，通过this@外部类名，指向外部类。

    */
    inner class TestViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var tv : TextView = itemView.findViewById(R.id.tv)
    }

}
