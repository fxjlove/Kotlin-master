package com.example.kotlin.ui

import android.arch.lifecycle.*
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.ui.viewmodel.TestViewModel
import kotlinx.android.synthetic.main.activity_other.*

/*
https://www.jianshu.com/p/dbf3843b8cd1
LiveData是一个具有生命周期感知特性的可观察的数据保持类，使用LiveData保存数据时，在每次订阅或数据更新时会自动回调设置的观察者从而更新数据，真正的实现了数据驱动的效果
LiveData的创建基本会在ViewModel中，从而使数据在界面销毁时继续保持
LiveData 认为观察者的生命周期处于STARTED状态或RESUMED状态下，表示观察者处于活动状态，LiveData只通知活跃的观察者更新数据
注册一个实现该LifecycleOwner 接口的对象配对的观察者，当相应Lifecycle对象的状态改变为DESTROYED时需移除观察者

*/

class LiveDataActivity : AppCompatActivity(){

    private lateinit var mModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        //创建一个定义onChanged()方法的Observer对象，在数据变化时回调
        // 创建观察者对象
        val nameObservable = Observer<String> {
            tv_01.text = it // onChange() 方法中的操作
        }

        //使用observe() 方法将观察者对象附加到LiveData对象，这将观察对象向LiveData对象订阅，以便通知其更改
        // 创建viewModel 对象
        mModel = ViewModelProviders.of(this).get(TestViewModel::class.java)

        // mCurrent 订阅观察
        mModel.mCurrent!!.observe(this,nameObservable)
/*
        1.第一个参数传递的this就是LifecycleOwner 的实例，LiveData会根据Owner的声明周期自动作相应的处理
        2.observe()将nameObservable作参数调用后，如果LiveData数据有值，onChange（）立即调用获取最新值
        3.可以使用observeForever(Observer)方法注册一个没有关联的生命周期所有者对象的观察者，在这种情况下，观察者被认为总是活动的，因此总是通知修改，可以删除这些观察员调用removeObserver(Observer) 方法

        */



        //设置点击事件，修改LiveData中的数据
        iv.setOnClickListener{
            mModel.mCurrent!!.value = "AAAAAA1"
        }
        //当LiveData对象保存的数据发生变化时，UI会自动响应更新
        //观察者在从非活动状态变为活动状态时也会收到更新

/*
        LiveData 整个过程就是两部分

                一是使用LifeCycleOwner感知声明周期的变化
        第二就是储存并遍历Observer，在数据改变时回调所有的观察者*/
    }


}
