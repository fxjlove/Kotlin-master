package com.example.kotlin.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.kotlin.R

class RVListenerAdapter(mContext: Context, data:ArrayList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private  var data = data
    private  var mContext  = mContext

    //定义一个函数式接口
//    var listener:((itemBean:ITEMBEAN)->Unit?)? =null
    private var listener: ((View,Int) -> Unit)? = null
//    private var listener: (() -> Unit)? = null
    //给函数式接口传值，也就是传递一个函数，至于函数实现什么功能，用户自己定义
    fun setMyListener(listener: ( View,Int) -> Unit) {
        this.listener = listener
    }
//    fun setOnTitleClickListener(action: (View, String) -> Unit) {
//        this.listener = action
//    }


    //函数变量mListener， 他的输入为int，返回值为Unit(kotlin的null，不过是个具体的对象)
    var mListener: ((pos: Int) -> Unit)? = null
    fun setOnItemClickListener(listener: ((pos: Int) -> Unit)){
        mListener = listener
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.recycleview_item,p0, false)
        var holder: RecyclerView.ViewHolder = ViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
       /* viewHolder.tv.text = data.get(position).toString()


        //下面就是kotlin调用这个函数，传递数据的过程
        viewHolder.itemView.setOnClickListener{
//            listener?.let{
//                position
//            }
            listener?.invoke(it,position)
            //let表达式表示如果为空就不会执行
            //listener?.invoke(data) 也可以
        }*/




        viewHolder?.run {
            tv.text = data.get(position)
            itemView.setOnClickListener {
                listener?.invoke(it,position)
            }
        }
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv : TextView = itemView.findViewById(R.id.tv)
    }




}