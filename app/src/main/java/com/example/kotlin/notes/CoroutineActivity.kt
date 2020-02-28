package com.example.kotlin.notes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_other.*
import kotlinx.coroutines.*
import java.lang.Runnable
import com.example.kotlin.R


/**
 * 协程
 */
class CoroutineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)



        /*new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tvThreadResult.setText("线程执行结果：第一种线程结果！");
            }
        }).start();*/

        Thread(Runnable {
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            tv_01.text = "线程执行结果：第一种线程结果！"
        }).start()




        val thread = object : Thread(){
            override fun run() {
                super.run()
                //do what you want to do.
            }
        }
        thread.start()


//        val myThread = thread {
//            //do what you want
//        }



//        val myThread2 = thread(start = false) {
//            //do what you want
//        }
//        //later on ...
//        myThread2.start()




        //todo 协程的启动
        //启动协程需要三样东西，分别是 上下文、启动模式、协程体，协程体
        GlobalScope.launch {
            //do what you want
        }

    }
}