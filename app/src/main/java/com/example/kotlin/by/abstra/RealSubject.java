package com.example.kotlin.by.abstra;

import com.example.kotlin.by.abstra.base.Subject;

//实现抽象主题的真实主题类
public class RealSubject extends Subject {
    @Override
    public void visit() {
        //RealSubject中的visit的具体逻辑
        System.out.print("Real subject");
    }
}