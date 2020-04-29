package com.example.kotlin.ktx

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_ktx.*
import kotlinx.android.synthetic.main.activity_main.*

/*


    Kotlin KTX
    是一个Kotlin 的扩展库，它能使本来已经简洁的Kotlin代码更加简洁，提高开发者开发者效率和使用体验




 */
class KtxActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ktx)

        //Kotlin
        val animator = ObjectAnimator.ofFloat(tv, "scaleY", 6f, 1f)
        animator.addListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }

        })

        //Kotlin with KTX
        val animator1 = ObjectAnimator.ofFloat(tv, "scaleY", 6f, 1f)
//        animator1.addListener {
//
//        }

        val myUriString = "";
        //kotlin
        val uri = Uri.parse(myUriString)

        //kotlin with android KTX
//        val uri2 = myUriString.toUri()

    }
}