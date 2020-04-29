package com.example.kotlin.designpatterns.observer.obs


//我们在声明一个抽象类，表示抽象的新闻客户端，实现Observer与ShowNewsInterface接口，然后定义PhoneNerwsClient与PadNewsClient继承NewsClient
abstract class NewsClient : Observer, ShowNewsInterface {
    var clientName: String = ""

    override fun show(time: Long, title: String, content: String) {
        println("${clientName} show ${title} at ${time}")
    }

    override fun update(time: Long, title: String, content: String) {
        show(time, title, content)
    }
}
