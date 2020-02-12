package com.example.kotlin.by.kotlin.attribute

/**
 * 定义一个AndroidDev类，实现SoftWareDev接口
 * 属性name委托Jobs类实现
 */
class AndroidDev : SoftWareDev {
    var name: String by Jobs()
}