package com.example.kotlin.by.abstra;

import com.example.kotlin.by.abstra.base.Subject;

//代理类
public class ProxySubject extends Subject {
    //持有真正主题的引用
    private RealSubject mSubject;

    //通过构造传入真正主主题的引用
    public ProxySubject(RealSubject mSubject) {
        this.mSubject = mSubject;
    }

    @Override
    public void visit() {
        //通过真实主题的引用的对象调用真实主题中的逻辑方法
        mSubject.visit();
    }
}
