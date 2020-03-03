package com.example.kotlin.annotation



//Kotlin注解声明


//和一般的声明很类似，只是在class前面加上了annotation修饰符

@Target(AnnotationTarget.FUNCTION)
@Retention(value = AnnotationRetention.RUNTIME)
annotation class TestAnnotation(val value: Int) {
}