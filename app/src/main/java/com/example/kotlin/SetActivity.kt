package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * 集合，
 *      集合根据特性分：
 *      1、有序可重复 -Array
 *      2、无序不重复 -Set
 *      3、无序可重复 -Map，有唯一的键（key）
 */

/**
 * Set 集合
 *
 * 集合类型：Set  无序不重复
 * 主要方法：交差并补
 *
 * https://www.cnblogs.com/it-tsz/p/11651544.html
 */
class SetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
/*


        setOf()：该函数返回不可变的Set集合。该函数可以接受0个或多个参数，这些参数将作为集合的元素。

        mutableSetOf()：该函数返回可变的MutableSet集合。该函数可接受0个或多个参数，这些参数将作为集合的元素。

        hashSetOf()：该函数返回可变的HashSet集合。该函数可接受0个或多个参数，这些参数将作为集合的元素。

        linkedSetOf()：该函数返回可变的LinkedHashSet集合。该函数可接受0个或多个参数，这些参数将作为集合的元素。

        sortedSetOf()：该函数返回可变的TreeSet集合。该函数可接受0个或多个参数，这些参数将作为集合的元素。

*/

        //Set写法：Set<类型>  或 setOf(元素1,...元素n)；大小固定，元素类型不可变
        val setOne = setOf<String>("1", "2", "3", "4")
        val setTwo = setOf<String>("1", "5", "8")
        val setThree = setOf<String>("1", "4")
        println("是否包含某个元素: " + setOne.contains("1"))
        println("是否包含某个集合 :" + setOne.containsAll(setThree))
        println("转化为数组 :" + setOne.toTypedArray())
        println("交集：" + setOne.intersect(setTwo))
        println("差集：" + setOne.subtract(setTwo))
        println("并集：" + setOne.union(setTwo))//结果默认去重复
        println("补集：" + setOne.minus(setTwo))
        //MutableSet<类型>  或  mutableSetOf(元素1,...元素n)；大小可变，类型不可变


        /**
         * 集合相关方法
         */
        val mutableSet = setOne.toMutableSet()
        //添加元素：add方法；添加集合：addAll方法
        //移除元素：remove方法；移除另一个集合：removeAll方法
        mutableSet.add("11")
        mutableSet.addAll(setTwo)
        mutableSet.remove("1")
        mutableSet.removeAll(setTwo)

        createSet()
        userSet();
        traverseSet()
        variableSet()
    }
    //一、声明和创建
    fun createSet(){
        println("一、声明和创建~~~~~~~~~~~~~~~~~~~~~~")
        //创建不可变集合，返回值是Set
        var set = setOf("Java", "Kotlin", "Go")
        println(set)//集合元素按添加顺序排列

        //创建可变集合，返回值是MutableSet
        var mutableSet = mutableSetOf("Java", "Kotlin", "Go")
        println(mutableSet)//集合元素按添加顺序排列
        println("setOf返回对象的实际类型：${set.javaClass}")
        println("mutableSetOf返回对象的实际类型：${mutableSet.javaClass}")

        //创建HashSet集合
        var hashSet = hashSetOf("Java", "Kotlin", "Go")
        println(hashSet)//不保证元素的顺序

        //创建LinkedHashSet集合
        var linkedHashSet = linkedSetOf("Java", "Kotlin", "Go")
        println(linkedHashSet)//集合元素按添加顺序排列

        //创建TreeSet集合
        var treeSet = sortedSetOf("Java", "Kotlin", "Go")
        println(treeSet)//集合元素由小到大排列
    }

    //二、使用Set的方法
    fun userSet(){
        println("二、使用Set的方法~~~~~~~~~~~~~~~~~~~~~~")
        //创建不可变集合，返回值是Set
        var set = setOf("Java", "Kotlin", "Go")
        //判断是否所有元素的长度都大于4
        println(set.all { it.length > 4 })
        //判断是否任一元素的长豆都大于4
        println(set.any { it.length > 4 })
        //以Lambda表达式的值为key，集合元素为value，组成Map集合
        val map = set.associateBy { "学习" + it + "语言" }
        println(map)

        println("Java" in set)
        println("Go" !in set)

        //返回删除Set集合前面两个元素后的集合
        val dropedList = set.drop(2)
        println(dropedList)

        //对Set集合元素进行过滤：要求集合元素包含li
        val fliteredList = set.filter { "li" in it }
        println(fliteredList)

        //查找Set集合中包含li的元素，如果找到就返回该元素，否则就返回null
        val foundStr1 = set.find { "li" in it }
        println(foundStr1)

        //查找Set集合中的所有字符串拼接在一起
        val foldedList = set.fold("", { acc, e -> acc + e })
        println(foldedList)

        //查找某个元素的出现位置
        println(set.indexOf("Go"))

        //将每个集合元素映射成新值，返回所有新值组成的Set集合
        val mappedList = set.map { "学习" + it + "编程" }
        println(mappedList)

        //获取最大值
        println(set.max())

        //获取最小值
        println(set.min())

        //反转集合顺序
        val reversedList = set.reversed()
        println(reversedList)

        val bSet = setOf("Lua", "Erlang", "Kotlin")
        //计算两个集合的交集
        println(set intersect bSet)
        //计算两个集合的并集
        println(set union bSet)
        //集合相加，相当于并集
        println(set + bSet)
        //集合相减，减去公共的元素
        println(set - bSet)
    }
    //三、遍历Set
    fun traverseSet(){
        println("三、遍历Set~~~~~~~~~~~~~~~~~~~~~~")
        //Kotlin也支持使用for-in循环遍历Set，与遍历数组的方式基本相同。
        var languages = setOf("Java", "Kotlin", "Python")
        for (language in languages) {
            println(language)
        }

        //Set集合可使用接口中定义的forEach()方法来遍历集合。
        languages.forEach { println(it) }


        //由于setOf()方法返回的Set集合是有序的，所以可以通过索引来遍历Set集合，Set集合提供了indices方法返回其索引的区间。
        for (i in languages.indices) {
            println(languages.elementAt(i))
        }

    }
    //四、可变的Set
    fun variableSet(){
        println("四、可变的Set~~~~~~~~~~~~~~~~~~~~~~")
        //setOf()函数返回的额集合是不可变集合；使用mutableSetof()、hashSetOf()、linkedSetOf()、sortedSetOf()函数返回的集合都是可变的

        //todo 添加元素

        /*Set提供了add(element:E)方法来添加元素，每调用该方法一次，就会向Set中添加一个元素，Set的长度也会自动加1.

        提供了addAll(elements:Collection<E>)方法来批量添加多个元素。*/
        //定义一个可变的Set
        var languages = mutableSetOf("Java")
        //添加一个元素
        languages.add("Go")
        languages.add("Lua")
        println(languages)
        println(languages.count())
        languages.addAll(setOf("Swift", "Kotlin"))
        println(languages)


        //todo 删除元素
       /* Set提供了如下方法来删除元素：

        remove(element:E)：删除指定元素，删除成功则返回true。
        removeAll(elements:Collection<E>)：批量删除Set集合中的多个元素。
        retainAll(elements:Collection<E>)：只保留Set集合中与elements集合共有的元素。
        clear()：清空集合。*/

        //定义一个可变的Set
        var languages2 = mutableSetOf("Java", "OC", "PHP", "Perl", "Ruby", "Go")
        //删除"PHP"
        languages2.remove("PHP")
        //再次删除"Perl"
        languages2.remove("Perl")
        println(languages)
        //批量删除多个元素
        languages2.removeAll(setOf("Ruby", "Go"))
        println(languages2)
        //清空Set集合
        languages.clear()
        println(languages2.count())

       // Kotlin的MutableIterator才相当于Java的Iterator。
    }

}