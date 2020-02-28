package com.example.kotlin.notes;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.kotlin.R;
import com.example.kotlin.common.Conant;
import com.example.kotlin.common.TopLevelClass;
import com.example.kotlin.function.StringFunctions1;
import com.example.kotlin.ext.StringUtilKtKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

import java.util.ArrayList;
import java.util.List;


public class FunctionActivity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        //Java中导入类和调用的时候就要使用我们自定义的类名来进行操作了
        StringFunctions1.joinToString();

        //java中导入扩展函数
        char c = StringUtilKtKt.lastChat("Java");
        Log.e("fxj","扩展函数~~~~~~~~~~~~~~~~~~~~~~");
        Log.e("fxj",c+"");


        //从java中访问扩展属性的时候，应该显示地调用他的getter函数
//        StringUtilKtKt.getLastChar3("android");


        //在JAVA 中使用函数类

        //在旧版的JAVA中，可以传递一个实现了函数接口中的invoke方法的匿名类的实例
        StringUtilKtKt.processTheAnswer(new Function1<Integer, Integer>() {
            @Override
            public Integer invoke(Integer number) {
                return number + 1;
            }
        });

        //可以在Java代码中使用Kotlin标准库中的函数
        List<String> list = new ArrayList<>();
        list.add("42");
        CollectionsKt.forEach(list , new Function1<String, Unit>() {
            @Override
            public Unit invoke(String s) {
                //必须要显式地返回一个Unit类型的值
                return Unit.INSTANCE;
            }
        });

        companion();
    }
    private void companion(){
        //引用静态方法（这里的引用只针对于java引用kotlin代码）
        Conant.Companion.test();
            //或者
//        Conant.StaticParams.test();

        //引用常量（这里的引用只针对于java引用kotlin代码）
//        String title = Conant.Companion.getLOAN_TITLE();
//        String title = Conant.StaticParams.getLOAN_TITLE();
        String title = Conant.LOAN_TITLE;



        TopLevelClass.Companion.doSomeStuff();
        TopLevelClass.FakeCompanion.INSTANCE.doOtherStuff();
    }
}
