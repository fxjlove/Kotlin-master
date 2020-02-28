package com.example.kotlin.notes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import com.example.kotlin.R
import com.example.kotlin.applybean.Resp
import com.example.kotlin.applybean.User
import com.example.kotlin.applybean.User2
import com.example.kotlin.applybean.User3
import kotlinx.android.synthetic.main.activity_apply.*
import org.jetbrains.anko.toast
import java.util.*

/**
 * apply
 *
 *   https://blog.csdn.net/guijiaoba/article/details/78975011
 *
 *   https://blog.csdn.net/u013064109/article/details/78786646
 *
 *   let,apply,run,with等函数区别
 */
class ApplyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)

//        applyTest()
//
//        repeatTest()
//
//        withTest()
//
//        letTest()

//        runTest()

//        test()

//        respTest()

        twoTest()

    }

    /**
     * apply
     *
     * 调用某对象的apply函数，在函数范围内，可以任意调用该对象的任意方法，并返回该对象
     */
    fun applyTest() {
        var title = "标题"

        tv_01.apply {
            text = title
            alpha = 0.5F
        }

//        tv_01.paint.isFakeBoldText = true

        testApply()
    }

    fun testApply() {
        // fun <T> T.apply(f: T.() -> Unit): T { f(); return this }
        ArrayList<String>().apply {
            add("testApply")
            add("testApply")
            add("testApply")
            println("this = " + this)
        }.let { println(it) }
    }

    /**
     * repeat函数是一个单独的函数
     */
    private fun repeatTest() {
        //循环执行多少次block中内容
        repeat(3) {
            println("Hello world")
            println(it)
        }
    }

    /**
     * with函数也是一个单独的函数，并不是Kotlin中的extension，指定的T作为闭包的receiver，使用参数中闭包的返回结果
     */
    private fun withTest() {

    }

    private fun letTest() {
        testLet()

        testLet2()
    }

    /**
     * 首先let()的定义是这样的，默认当前这个对象作为闭包的it参数，返回值是函数里面最后一行，或者指定return
     *
     * fun <T, R> T.let(f: (T) -> R): R = f(this)
     */
    private fun testLet(): Int {
        // fun <T, R> T.let(f: (T) -> R): R { f(this)}
        "testLet".let {
            println(it)
            println(it)
            println(it)
            return 1
        }
    }

    private fun testLet2(): Int {
        // fun <T, R> T.let(f: (T) -> R): R { f(this)}
        "testLet".let {
            if (Random().nextBoolean()) {
                println(it)
                return 1
            } else {
                println(it)
                return 2
            }
        }
    }

    /**
     * run函数和apply函数很像，只不过run函数是使用最后一行的返回，apply返回当前自己的对象。
     *
     * fun <T, R> T.run(f: T.() -> R): R = f()
     */
    private fun runTest() {
        "testRun".run {
            println("this = " + this)
        }.let { println(it) }
    }


    private fun test() {
        println("普通的赋值语句～～～～～～～～～～～～～～～～～～～")
        //普通的赋值语句
        var user = User()
        user.id = 1
        user.name = "test1"
        user.hobbies = listOf("aa", "bb", "cc")
        println("user = $user")

        //如果使用let,apply,run,with可以这样，let和also是需要it的，其他的默认使用this。
        println("let～～～～～～～～～～～～～～～～～～～")

        user.let {
            it.id = 2
            it.name = "test2"
            it.hobbies = listOf("aa", "bb", "cc")
        }
        println("user = $user")

        println("also～～～～～～～～～～～～～～～～～～～")
        user.also {
            it.id = 3
            it.name = "test3"
            it.hobbies = listOf("aa", "bb", "cc")
        }
        println("user = $user")

        println("apply～～～～～～～～～～～～～～～～～～～")
        user.apply {
            id = 4
            name = "test4"
            hobbies = listOf("aa", "bb", "cc")
            Date()
        }
        println("user = $user")

        println("run～～～～～～～～～～～～～～～～～～～")
        user.run {
            id = 5
            name = "test5"
            hobbies = listOf("aa", "bb", "cc")
            Date()
        }
        println("user = $user")

        println("with～～～～～～～～～～～～～～～～～～～")
        with(user) {
            id = 6
            name = "test6"
            hobbies = listOf("aa", "bb", "cc")
            Date()
        }
        println("user = $user")


    }

    private fun respTest() {
        var resp: Resp<String>? = Resp()
        resp?.body = "啦啦啦"
        resp?.errorMessage = "失败"

        println("普通～～～～～～～～～～～～～～～～～～～")
        if (resp != null) {
            if (resp.isSuccess()) {
                // do success
                println(resp.body)
            } else {
                // do fail
                println(resp.errorMessage)
            }
        }
        println("run～～～～～～～～～～～～～～～～～～～")
        resp?.run {
            if (isSuccess()) {
                // do success
                println(resp.body)
            } else {
                println(resp.errorMessage)
            }
        }
        println("apply～～～～～～～～～～～～～～～～～～～")
        resp?.apply {
            if (isSuccess()) {
                // do success
                println(resp.body)
            } else {
                println(resp.errorMessage)
            }
        }
        println("let～～～～～～～～～～～～～～～～～～～")
        resp?.let {
            if (it.isSuccess()) {
                // do success
                println(it.body)
            } else {
                println(it.errorMessage)
            }
        }
        println("also～～～～～～～～～～～～～～～～～～～")
        resp?.also {
            if (it.isSuccess()) {
                // do success
                println(it.body)
            } else {
                println(it.errorMessage)
            }
        }
    }

    /**
     * let、apply、with、run
     *
     * https://blog.csdn.net/zhaoyanjun6/article/details/94402604
     */
    private fun twoTest() {

//        let()

//        apply()

//        with()

//        run()

        also()
    }

    /*

    内联扩展函数之let
    let扩展函数的实际上是一个作用域函数，当你需要去定义一个变量在一个特定的作用域范围内，let函数的是一个不错的选择；let函数另一个作用就是可以避免写一些判断null的操作。

    let可以配合可空性 “?”来使用，如果data=null 则不执行let内部代码，如果有返回值则直接返回null
    在let中，用it表示引用对象，并可调用其方法，it不可省略。
    返回值是语句块的最后一行的返回类型，若最后一行语句无返回值，则整个let语句块也无返回值
    */
    private fun let() {
        /*
        let函数的使用的一般结构
        object.let{
            it.todo()//在函数体内使用it替代object对象去访问其公有的属性和方法
            ...
        }

        //另一种用途 判断object为null的操作
        object?.let{//表示object不为null的条件下，才会去执行let函数体
            it.todo()
        }

      */

        var list: ArrayList<Int>? = ArrayList()

        Log.e("let", "基础用法~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
        list?.let {
            it.add(1)
            it.add(2)
            it.add(3)
        }
        Log.e("let", "$list")

        Log.e("let", "返回值~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
        list?.clear()
        //let的返回值为 let 语句块的最后一行
        var result = list?.let {
            it.add(1)
            it.add(2)
            it.add(3)
            "ok"
        }
        Log.e("let:", "$list  $result")


        Log.e("let", "android实战~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
        tv_01?.let {
            it.text = "zhaoyanjun"
            it.textSize = 20f
            it.setOnClickListener {
                Toast.makeText(it.context, "click", Toast.LENGTH_SHORT).show()
            }
        }
/*

        let函数适用的场景

        场景一: 最常用的场景就是使用let函数处理需要针对一个可null的对象统一做判空处理。

        场景二: 然后就是需要去明确一个变量所处特定的作用域范围内可以使用

*/

        val result2 = "testLet".let {
            println(it.length)
            Log.e("let", it.length.toString())
            1000
        }
        println(result2)
        Log.e("let", "$result2")

/*
        let函数使用前后的对比

        没有使用let函数的代码是这样的，看起来不够优雅
        mVideoPlayer?.setVideoView(activity.course_video_view)
        mVideoPlayer?.setControllerView(activity.course_video_controller_view)
        mVideoPlayer?.setCurtainView(activity.course_video_curtain_view)

        使用let函数后的代码是这样的
        mVideoPlayer?.let {
            it.setVideoView(activity.course_video_view)
            it.setControllerView(activity.course_video_controller_view)
            it.setCurtainView(activity.course_video_curtain_view)
        }*/
    }

    /*

    内联扩展函数之apply

     apply使用this指代T，函数值返回值是Unit。但apply通过return this主动返回T的实例。
     如果构造过程中需要初始化的变量较多，使用apply形成的代码块会非常直观。
     */
    private fun apply() {
        //示例
        //创建LinearLayout并利用apply设置初始化参数，最后返回初始化完毕的LinearLayout实例。

        val linearLayout1 = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }
        //上面的代码等价于：
        val linearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
/*
        apply函数使用的一般结构

        object.apply{
            //todo
        }

        apply函数的inline结构分析

        从结构上来看apply函数和run函数很像，唯一不同点就是它们各自返回的值不一样，run函数是以闭包形式返回最后一行代码的值，而apply函数的返回的是传入对象的本身。


        */
        val user = User3("Kotlin", 1, "1111111")

        val result = user.apply {
            println("my name is $name, I am $age years old, my phone number is $phoneNum")
            1000
        }
        println("result: $result")
/*
        apply函数的适用场景

        整体作用功能和run函数很像，唯一不同点就是它返回的值是对象本身，而run函数是一个闭包形式返回，返回的是最后一行的值。正是基于这一点差异它的适用场景稍微与run函数有点不一样。apply一般用于一个对象实例初始化的时候，需要对对象中的属性进行赋值。或者动态inflate出一个XML的View的时候需要给View绑定数据也会用到，这种情景非常常见。特别是在我们开发中会有一些数据model向View model转化实例化的过程中需要用到。

        apply函数使用前后的对比

        没有使用apply函数的代码是这样的，看起来不够优雅
        mSheetDialogView = View.inflate(activity, R.layout.biz_exam_plan_layout_sheet_inner, null)
        mSheetDialogView.course_comment_tv_label.paint.isFakeBoldText = true
        mSheetDialogView.course_comment_tv_score.paint.isFakeBoldText = true
        mSheetDialogView.course_comment_tv_cancel.paint.isFakeBoldText = true
        mSheetDialogView.course_comment_tv_confirm.paint.isFakeBoldText = true
        mSheetDialogView.course_comment_seek_bar.max = 10
        mSheetDialogView.course_comment_seek_bar.progress = 0


        使用apply函数后的代码是这样的
        mSheetDialogView = View.inflate(activity, R.layout.biz_exam_plan_layout_sheet_inner, null).apply{
            course_comment_tv_label.paint.isFakeBoldText = true
            course_comment_tv_score.paint.isFakeBoldText = true
            course_comment_tv_cancel.paint.isFakeBoldText = true
            course_comment_tv_confirm.paint.isFakeBoldText = true
            course_comment_seek_bar.max = 10
            course_comment_seek_bar.progress = 0

        }

        多层级判空问题

	if (mSectionMetaData == null || mSectionMetaData.questionnaire == null || mSectionMetaData.section == null) {
			return;
		}
		if (mSectionMetaData.questionnaire.userProject != null) {
			renderAnalysis();
			return;
		}
		if (mSectionMetaData.section != null && !mSectionMetaData.section.sectionArticles.isEmpty()) {
			fetchQuestionData();
			return;
		}


    kotlin的apply函数优化
    mSectionMetaData?.apply{

    //mSectionMetaData不为空的时候操作mSectionMetaData

    }?.questionnaire?.apply{

    //questionnaire不为空的时候操作questionnaire

    }?.section?.apply{

    //section不为空的时候操作section

    }?.sectionArticle?.apply{

    //sectionArticle不为空的时候操作sectionArticle

}

        */
    }

    /*

    内联函数之with

        接收一个receiver和一个函数式，通过this调用receiver，返回值根据函数式最后一个返回值为准。

        一般会在传入receiver的时候就地创建实例，不然使用apply来替代with会是更好的选择。

        可为null时别和with搭档*/
    private fun with() {
        /*
        with函数使用的一般结构

         with(object){
           //todo
         }

      */
        Log.e("with", "返回值为一个字符串~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
        with(ArrayList<String>()) {
            add("a")
            add("b")
            "ok"
        }

        Log.e("with", "返回值为 this~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
        var list = with(ArrayList<String>()) {
            add("a")
            add("b")
            this
        }

        list.add("c")

/*

       with函数inline结构的分析

        with函数和前面的几个函数使用方式略有不同，因为它不是以扩展的形式存在的。它是将某对象作为函数的参数，在函数块内可以通过 this 指代该对象。返回值为函数块的最后一行或指定return表达式。

        可以看出with函数是接收了两个参数，分别为T类型的对象receiver和一个lambda函数块，所以with函数最原始样子如下:

        val result = with(user, {
            println("my name is $name, I am $age years old, my phone number is $phoneNum")
            1000
        })



        但是由于with函数最后一个参数是一个函数，可以把函数提到圆括号的外部，所以最终with函数的调用形式如下:

        val result = with(user) {
            println("my name is $name, I am $age years old, my phone number is $phoneNum")
            1000
        }
*/


        val user = User2("Kotlin", 1, "1111111")

        val result = with(user) {
            println("my name is $name, I am $age years old, my phone number is $phoneNum")
            1000
        }
        println("result: $result")
/*

        with函数的适用的场景

        适用于调用同一个类的多个方法时，可以省去类名重复，直接调用类的方法即可，经常用于Android中RecyclerView中onBinderViewHolder中，数据model的属性映射到UI上

        with函数使用前后的对比
        没有使用kotlin中的实现
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            ArticleSnippet item = getItem(position);
            if (item == null) {
                return;
            }
            holder.tvNewsTitle.setText(StringUtils.trimToEmpty(item.titleEn));
            holder.tvNewsSummary.setText(StringUtils.trimToEmpty(item.summary));
            String gradeInfo = "难度：" + item.gradeInfo;
            String wordCount = "单词数：" + item.length;
            String reviewNum = "读后感：" + item.numReviews;
            String extraInfo = gradeInfo + " | " + wordCount + " | " + reviewNum;
            holder.tvExtraInfo.setText(extraInfo);
            ...
        }

        kotlin的实现
        override fun onBindViewHolder(holder: ViewHolder, position: Int){
            val item = getItem(position)?: return

            with(item){

                holder.tvNewsTitle.text = StringUtils.trimToEmpty(titleEn)
                holder.tvNewsSummary.text = StringUtils.trimToEmpty(summary)
                holder.tvExtraInf.text = "难度：$gradeInfo | 单词数：$length | 读后感: $numReviews"
                ...

            }

        }
*/


    }

    /**
     * 内联扩展函数之run
     *
     * 执行传入的函数式，并返回函数的执行结果。run的主要目的是强调需要执行的函数。
     */
    private fun run() {
        // 从intent取EXTRA_URL的值，不为非空且内容不为空，赋值给url。否则弹出提示并关闭页面。
        // Init url:String
        var url = intent.getStringExtra("EXTRA_URL")?.takeIf { it.isNotEmpty() } ?: run {
            toast("不能浏览一个空链接哦")
            this.finish()
        }

        /* run函数使用的一般结构

         object.run{
             //todo
         }

         run函数的inline结构分析

        run函数实际上可以说是let和with两个函数的结合体，run函数只接收一个lambda函数为参数，以闭包形式返回，返回值为最后一行的值或者指定的return的表达式。


         */

        val user = User2("Kotlin", 1, "1111111")

        val result = user.run {
            println("my name is $name, I am $age years old, my phone number is $phoneNum")
            1000
        }
        println("result: $result")


/*

        run函数的适用场景
        适用于let,with函数任何场景。因为run函数是let,with两个函数结合体，准确来说它弥补了let函数在函数体内必须使用it参数替代对象，在run函数中可以像with函数一样可以省略，直接访问实例的公有属性和方法，另一方面它弥补了with函数传入对象判空问题，在run函数中可以像let函数一样做判空处理

        run函数使用前后的对比
        还是借助上个例子kotlin代码
        override fun onBindViewHolder(holder: ViewHolder, position: Int){
            val item = getItem(position)?: return

            with(item){

                holder.tvNewsTitle.text = StringUtils.trimToEmpty(titleEn)
                holder.tvNewsSummary.text = StringUtils.trimToEmpty(summary)
                holder.tvExtraInf = "难度：$gradeInfo | 单词数：$length | 读后感: $numReviews"
                ...

            }

        }

        使用run函数后的优化
        override fun onBindViewHolder(holder: ViewHolder, position: Int){

            getItem(position)?.run{
                holder.tvNewsTitle.text = StringUtils.trimToEmpty(titleEn)
                holder.tvNewsSummary.text = StringUtils.trimToEmpty(summary)
                holder.tvExtraInf = "难度：$gradeInfo | 单词数：$length | 读后感: $numReviews"
                ...

            }

        }
*/


    }

    /**
     *
     * 内联扩展函数之also
     */
    private fun also(){
        /*
        also函数使用的一般结构
        object.also{
            //todo
        }

        also函数的inline+lambda结构
        @kotlin.internal.InlineOnly


        also函数的inline结构分析
        also函数的结构实际上和let很像唯一的区别就是返回值的不一样，let是以闭包的形式返回，返回函数体内最后一行的值，如果最后一行为空就返回一个Unit类型的默认值。而also函数返回的则是传入对象的本身


         also函数的适用场景:
        适用于let函数的任何场景，also函数和let很像，只是唯一的不同点就是let函数最后的返回值是最后一行的返回值而also函数的返回值是返回当前的这个对象。一般可用于多个扩展函数链式调用

        also函数使用前后的对比:
        和let函数类似
*/

        //also函数返回的则是传入对象的本身
        val result = "testLet".also {
            println(it.length)
            1000
        }
        println(result)




    }




}