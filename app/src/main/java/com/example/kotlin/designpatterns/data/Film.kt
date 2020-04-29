package com.example.kotlin.designpatterns.data

//Kotlin因为使用 data class 时，会自动获得equals、hashCode、toString和copy方法，相对java简便很多，copy方法可以克隆整个对象并且允许修改新对象某些属性。
data class Film(var name: String, var content: String?, var actorList: String?)
