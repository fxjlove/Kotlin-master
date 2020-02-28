package com.example.kotlin.notes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.R
import kotlinx.coroutines.*


/**
 * 协程
 */
class CoroutineActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

/*
        1.在Kotlin中启动协程"

        runBlocking: T
        用于执行协程任务，通常只用于启动最外层的协程（线程到协程的调度）

        launch: Job
        用于执行协程任务，返回的 Job 是一个接口引用

        async/await: Deferred
        用于执行协程任务，并得到执行结果





        2.协程的启动参数

        以下是 launch 的参数列表，runBlocking、async 与 launch 参数列表是差不多的

        context: CoroutineContext = DefaultDispatcher
        当前 协程 的上下文，用于在 协程 与 协程 之间参数传递
        可以用于声明当前 协程 在哪一个线程中声明，以及当前 协程 被中断后，在哪一个线程中恢复它
        DefaultDispatcher 就是一个默认的调度器，当前哪个线程在运行，就直接取哪个线程
        start: CoroutineStart = CoroutineStart.DEFAULT
        协程 的启动参数，表示已哪种方式启动
        CoroutineStart.DEFAULT 默认的启动方式，表示当前线程什么时候有空，就什么时候启动
        可选参数：LAZY，如果没有手动调用 job 对象的 start() 或 join() 方法的话，那么该 协程 是不会被启动的
        可选参数：ATOMIC，将 协程 以一个原子性质的形式的启动，如果声明此参数，则协程是不可以 cancel 的
        可选参数：UNDISPATCHED，未定义，通常用于自定义的启动方式，如果未自定义，则与 DEFAULT 启动方式一致。
        parent: Job? = null
        表示在当前 协程 闭包的外层的 job，一般情况下使用不到
        block: suspend CoroutineScope.() -> Unit
        协程真正要去执行的内容

       */

        main(ArrayList<String>())
     }

    /**
     * main=runBlocking
     * 表示主线程开始后直接就开启了一个协程
     * 在协程中执行任务
     */
    fun main(args: ArrayList<String>) = runBlocking {

        val job = launch {
            repeat(10) { i ->

                println("挂起中------$i")
                //每次循环，暂停1秒
                delay(1000L)

            }
        }

        val job2 = async {
            //挂起5秒
            delay(5000L)
            //使用注解标注此处返回的是 async 的闭包
            return@async "我是 async 返回的内容"
        }

        /**
         * await 是一个阻塞式方法
         * 会将主线程停在这里
         * 当 job2 挂起5秒结束，返回内容
         * await 接受到内容，主线程才继续向下执行-->开始等待
         */
        println("job2 返回的内容：${job2.await()}")
        println("主线程开始等待-----")
        delay(3000L)
        println("主线程等待结束-----取消launch开启的协程")
        job.cancel()//协程的启动和停止都是代码可控的

        println("主线程执行完毕，即将推出-----")

    }
}