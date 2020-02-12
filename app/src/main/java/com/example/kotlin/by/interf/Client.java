package com.example.kotlin.by.interf;

import com.example.kotlin.by.abstra.RealSubject;

import java.lang.reflect.Proxy;

//客户端类
public class Client {
    public static void main(String[] args){
        //构造一个真实的主题对象
        RealSubject realSubject=new RealSubject();
        //构造一个动态代理
        DynamicProxy proxy=new DynamicProxy(realSubject);
        //获取一个真实代理类的ClassLoader
        ClassLoader loader=realSubject.getClass().getClassLoader();
        //动态构造一个代理类
        Subject subject=(Subject) Proxy.newProxyInstance(loader,new Class[]{Subject.class},proxy);
        //调用代理相关方法
        subject.visit();
    }
}
