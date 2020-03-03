package com.example.kotlin.annotation;

//Java注解声明


//java中的注解通过@interface关键字进行定义，它和接口声明类似，只不过在前面多加@
public @interface TestAnnotationJava {
    String value();
}
