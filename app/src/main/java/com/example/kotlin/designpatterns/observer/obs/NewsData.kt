package com.example.kotlin.designpatterns.observer.obs

//被观察者
//有了被观察者的行为接口后，我们再来定义被观察者的主体，这里有time、title、content三个成员变量，同时定义receiveNews的方法表示从外部接收新闻、声明一个List用来维护已经添加的观察者。
class NewsData() : Subject {

    var time: Long = 0
    var title: String = ""
    var content: String = ""

    var observerList: ArrayList<Observer> = ArrayList()

    override fun registerObserver(observer: Observer) {
        observerList.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        val index = observerList.indexOf(observer)
        if (index >= 0) {
            observerList.removeAt(index)
        }
    }

    override fun notifyObserver() {
        for (observer in observerList) {
            observer.update(time, title, content)
        }
    }

    fun receiveNews(time : Long, title : String, content : String) {
        this.time = time
        this.title = title
        this.content = content
        notifyObserver()
    }
}
