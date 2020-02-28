package com.example.kotlin.notes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.R

/**
 * Kotlin中有三个跳跃表达式。 这些跳转表达式用于控制程序执行的流程。 这些跳跃语句是：

    break
    continue
    return


 */
class BreakActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)

//        breakTest()

        continueTest()
    }
    private fun breakTest(){

        for (i in 1..5) {
            if (i == 3) {
                break
            }
            println(i)
        }

        println("~~~~~~~~~~~~Kotlin标记break表达~~~~~~~~~~~~")

        loop@ for (i in 1..3) {
            for (j in 1..3) {
                println("i = $i and j = $j")
                if (i == 2)
                    break@loop
            }
        }

        println("~~~~~~~~~~~~Kotlin不标记break表达~~~~~~~~~~~~")

        for (i in 1..3) {
            for (j in 1..3) {
                println("i = $i and j = $j")
                if (i == 2)
                    break
            }
        }

    }

    private fun continueTest(){
        for (i in 1..3) {
            println("i = $i")
            if (i == 2) {
                continue
            }
            println("this is below if")
        }

        println("~~~~~~~~~~~~Kotlin标记continue表达式~~~~~~~~~~~~")
        /*
        标记是标识符的形式，后跟@符号，例如abc@，test@。 要将表达式作为标签，只需在表达式前面添加一个标签。
        标记为continue表达式，在Kotlin中用于重复特定的循环(标记的循环)。 通过使用带有@符号后跟标签名称的continue表达式(continue@labelname)来完成的。
*/
        labelname@ for (i in 1..3) {
            for (j in 1..3) {
                println("i = $i and j = $j")
                if (i == 2) {
                    continue@labelname
                }
                println("this is below if")
            }
        }

    }
}




