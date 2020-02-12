package com.example.kotlin.by.abstra;

//客户类
public class Client {
    public static void main(String[] args){
        //构造一个真实的主题对象
        RealSubject realSubject=new RealSubject();
        //通过真实的主题对象构造一个代理对象
        ProxySubject proxySubject=new ProxySubject(realSubject);
        //调用代理相关方法
        proxySubject.visit();
    }
    /*
    https://www.jianshu.com/p/a70ba6436e75/

    JAVA代理模式

    代理模式定义

    为其他对象提供一种代理以控制对象对这个对象的访问。

    代理模式的使用场景

    当无法或不想直接访问某个对象或访问某个对象存在困难时可以通过一个代理对象来间接访问，为了保证客户端使用的透明性，委托对象与代理对象需要实现相同的接口。


    */
}
