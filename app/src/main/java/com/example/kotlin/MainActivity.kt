package com.example.kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.view.Gravity
import android.view.View
import android.widget.Toast
//作用:添加了这一行后我们就不需要再findViewById就可以了，
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import android.util.Log


/**
 *  : AppCompatActivity() ：类名，表示继承于什么类
 *  ，View.OnClickListener, View.OnLongClickListener 表示继承于 View.OnClickListener 点击事件接口, View.OnLongClickListener 长按事件接口
 */
class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {

//    var <标识符> : <类型> = <初始化值>
    //为TextView控件赋值

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //todo TextView

        //java 使用方法
        tv_fuzhi.setText("你好")


        //同样在kotlin 这种也是可以使用的 但是会有提示
        //为TextView设置值,koltin的语句后面是不需要;的，但是如果你加上也不会报错的
        tv_fuzhi.text = " 你好 世界 "
        tv_fuzhi.textSize = 20F
        tv_fuzhi.gravity = Gravity.CENTER
        tv_fuzhi.visibility = View.VISIBLE
//        tv_fuzhi.setTextColor(getResources().getColor(R.color.txt_color))
//        tv_fuzhi.setBackgroundColor(getResources().getColor(R.color.txt_bg))
        tv_fuzhi.setTextColor(ContextCompat.getColor(this, R.color.txt_color))
        tv_fuzhi.setBackgroundColor(ContextCompat.getColor(this, R.color.txt_bg))

        Log.e("fxj","txt:"+tv_fuzhi.text +"//"+ tv_fuzhi.text.trim() +"//" +tv_fuzhi.text.toString().trimMargin())


        //todo 点击事件

        //虽然我们通过import kotlinx.android.synthetic.main.activity_main.*使得不需要写控件的fndId，但是我们仍然是要写setOnClickListener(this)控件点击回调监听的
        //设置控件的回调监听
        //二：全局实现OnClickListener接口：
//        btn_01.setOnClickListener(this)
        clickListener()

        //一：匿名内部类：这种方式最简单
        btn_02.setOnClickListener() {
            //            Toast.makeText(this, "按钮2", Toast.LENGTH_LONG).show()
//            toast("按钮2");

            //跳转页面
//            //一：
//            val intent = Intent()
//            //获取intent对象
//            intent.setClass(this,OtherActivity::class.java)
//            // 获取class是使用::反射
//            startActivity(intent)

            //二：
//            val intent = Intent(this@MainActivity, OtherActivity::class.java)
//            startActivity(intent)

            var intent = Intent(KotlinActivity@this, OtherActivity::class.java)
            var bundle = Bundle()
            bundle.putString("name", "ABC")
            bundle.putInt("age", 123)
            intent.putExtras(bundle)
            startActivityForResult(intent, 0)


            //三：
            //todo anko页面跳转

            //1:正常跳转
//            startActivity<OtherActivity>()
            //携带参数
            //第一种写法，参数名和参数值使用关键字to隔开
//            startActivity<OtherActivity>("name" to "张三", "age" to 27)
//            startActivityForResult<OtherActivity>(101, "name" to "张三", "age" to 27)
//            startActivityForResult<OtherActivity>(
//                1,
//                "name" to "张三", "age" to 28
//            )




            //第二种写法，利用Pair把参数名和参数值进行配对
//            startActivity<OtherActivity>(
//                Pair("name", "张三"),
//                Pair("age", 27))

            //2:A页面跳到B页面,再跳到C页面,再跳到A页面时,要求清空B,C页面退出,并且不重走A的生命周期
//            startActivity(intentFor<OtherActivity>().singleTop().clearTop())

            //3:A页面跳到B页面,再跳到C页面,再跳到A页面时,要求清空B,C页面退出,并且重走A的生命周期
//            startActivity(intentFor<OtherActivity>().clearTask().newTask())

            //4:A页面->B页面->C页面->D页面时,销毁A.B.C这三个页面,整个栈中就D页面
//            startActivity(intentFor<OtherActivity>().newTask().clearTask())
        }


        //EditText

        et_01.hint = "请输入。。。。。。"

        //EditText赋值时使用editText.text = "value"时会提示Type mismatch，这是因为EditText在推断types时出现问题。 为了避免types不匹配，使用Editable类的Factory内部类，来解决这个问题。
//        et_01.text="姓名"
        et_01.text = Editable.Factory.getInstance().newEditable("姓名")
        //设置光标在末尾
        et_01.requestFocus()





    }

    fun clickListener() {
        btn_01.setOnClickListener(this)
    }


    /*这种方法与java的区别是没有implements关键字表示实现接口。

    when就相当于java中的switch。

    “:”符号改为了“->”。*/
    /**
     * 重写OnClickListener接口的onClick方法
     */
    override fun onClick(v: View?) {
        //在点击事件里面使用switch找到对应控件的id了，只是在kotlin里面是使用when
        when (v?.id) {
            R.id.btn_01 -> {
                Toast.makeText(this, "按钮1", Toast.LENGTH_LONG).show()
            }

        }
    }

    //三：指定onClick属性：
    fun click(v: View?) {
        when (v?.id) {
            R.id.btn_03 ->
                Toast.makeText(this, "按钮3", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * 重写OnLongClickListener接口的onLongClick方法
     * override符号为子类继承父类后，重写父类方法的符号
     * 其不同于我们的Java的地方在于，在Java中，该符号省略后不会报错，而kotlin会
     */
    override fun onLongClick(v: View?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_OK) {
            return
        }
        if(requestCode == 0){
            var name = data?.getStringExtra("name")
            toast("名字："+name);
        }
    }


    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}
