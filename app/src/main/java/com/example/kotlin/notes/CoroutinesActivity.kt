package com.example.kotlin.notes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.kotlin.R
import kotlinx.coroutines.*

/**
 * 协程
 */
class CoroutinesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)



//        runBlocking()

//        launch()

        async()
    }
    //todo 1.runBlocking:T
    private fun runBlocking(){
        Log.e("TAG", "主线程id：${mainLooper.thread.id}")
        test()
        Log.e("TAG", "协程执行结束")
    }
    //runBlocking启动的协程任务会阻断当前线程，直到该协程执行结束。当协程执行结束之后，页面才会被显示出来。
    private fun test() = runBlocking {
        repeat(8) {
            Log.e("TAG", "协程执行$it 线程id：${Thread.currentThread().id}")
            delay(1000)
        }
    }

    //todo 2.launch:Job
    //这是最常用的用于启动协程的方式，它最终返回一个Job类型的对象，这个Job类型的对象实际上是一个接口，它包涵了许多我们常用的方法。下面先看一下简单的使用：
    private fun launch(){
        Log.e("TAG", "主线程id：${mainLooper.thread.id}")
        val job = GlobalScope.launch {
            delay(6000)
            Log.e("TAG", "协程执行结束 -- 线程id：${Thread.currentThread().id}")
        }
        Log.e("TAG", "主线程执行结束")

        //从执行结果看出，launch不会阻断主线程。

/*

        //Job中的方法
        job.isActive
        job.isCancelled
        job.isCompleted
        job.cancel()
        jon.join()


        1.协程下上文

        Dispatchers.Main：使用这个调度器在 Android 主线程上运行一个协程。可以用来更新UI 。在UI线程中执行

        Dispatchers.IO：这个调度器被优化在主线程之外执行磁盘或网络 I/O。在线程池中执行

        Dispatchers.Default：这个调度器经过优化，可以在主线程之外执行 cpu 密集型的工作。例如对列表进行排序和解析 JSON。在线程池中执行。

        Dispatchers.Unconfined：在调用的线程直接执行。

        调度器实现了CoroutineContext接口。

*/

    }

    //todo 3.async
    //async跟launch的用法基本一样，区别在于：async的返回值是Deferred，将最后一个封装成了该对象。async可以支持并发，此时一般都跟await一起使用，看下面的例子。
    private fun async(){

        GlobalScope.launch {
            val result1 = GlobalScope.async {
                getResult1()
            }
            val result2 = GlobalScope.async {
                getResult2()
            }
            val result = result1.await() + result2.await()
            Log.e("TAG","result = $result")
        }
        //async是不阻塞线程的,也就是说getResult1和getResult2是同时进行的，所以获取到result的时间是4s，而不是7s。
    }

    private suspend fun getResult1(): Int {
        delay(3000)
        return 1
    }

    private suspend fun getResult2(): Int {
        delay(4000)
        return 2
    }
}