package com.example.kotlin.by.kotlin.attribute

/**
 * 定义一个PhpDev类，实现了SoftWareDev接口
 * 属性name委托Jobs类实现
 */
class PhpDev : SoftWareDev {
    var name: String by Jobs()
}