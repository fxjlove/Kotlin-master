package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * 数组
 *
 *  https://www.jianshu.com/p/da5cc9072f1e
 *
 */
class MapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        createMap()
//
        useMap()

        traverseMap()

        variableMap()

    }
    //一、创建创建Map集合
    fun createMap(){
        //1.mapOf

        //创建不可变集合，返回值是Map
        var map = mapOf("Java" to 86, "Kotlin" to 92, "Go" to 78)
        Log.e("fxj","map:"+map)//按添加顺序排列
        Log.e("fxj","mapOf的返回对象的实际类型：${map.javaClass}")


        //2.mutableMapOf

        //创建可变集合
        var mutableMap = mutableMapOf("Java" to 86, "Kotlin" to 92, "Go" to 78)
        Log.e("fxj","mutableMap:"+mutableMap)//按添加顺序排列
        Log.e("fxj","mutableMapOf的返回对象的实际类型：${mutableMap.javaClass}")


        //3.hashMapOf

        //创建HashMap集合
        var hashMap = hashMapOf("Java" to 86, "Kotlin" to 92, "Go" to 78)
        Log.e("fxj","hashMap:"+hashMap)//不保证排列顺序
        Log.e("fxj","hashMapOf的返回对象的实际类型：${hashMap.javaClass}")


        //4.linkedMapOf

        //创建LinkedHashMap
        var linkedHashMap = linkedMapOf("Java" to 86, "Kotlin" to 92, "Go" to 78)
        Log.e("fxj","linkedHashMap:"+linkedHashMap)//按添加顺序排列
        Log.e("fxj","linkedMapOf的返回对象的实际类型：${linkedHashMap.javaClass}")


        //5.sortedMapOf

        //创建TreeMap集合
        var treeMap = sortedMapOf("Java" to 86, "Kotlin" to 92, "Go" to 78)
        Log.e("fxj","treeMap:"+treeMap)//按key由小到大排列
        Log.e("fxj","sortedMapOf的返回对象的实际类型：${treeMap.javaClass}")



    }

    //二、使用Map的方法
    fun useMap(){

        //创建不可变集合，返回值是Map
        var map = mapOf("Java" to 86, "Kotlin" to 92, "Go" to 78)
        //判断是否所有key-value对的key的长度都大于4，value都大于80
        Log.e("fxj","map1:"+map.all { it.key.length > 4 && it.value > 80 })
        //判断是否任一key-value对的key的长豆都大于4、value都大于80
        Log.e("fxj","map2:"+map.any { it.key.length > 4 && it.value > 80 })


        Log.e("fxj", ("Java" in map).toString())
        Log.e("fxj", ("Go" !in map).toString())



        //对Map集合元素进行过滤：要求key包含li
        val filteredMap = map.filter { "li" in it.key }
        Log.e("fxj","filteredMap:"+filteredMap)



        //将每个key-value对映射成新值，返回所有新值组成的Map集合
        val mappedList = map.map { "${it.key}有${it.value}节课" }
        Log.e("fxj","mappedList:"+mappedList)


        //根据key获取最大值
        Log.e("fxj","map3:"+map.maxBy { it.key })
        //根据value获取最小值
        Log.e("fxj","map4:"+map.minBy { it.value })



        var bMap= mapOf("Lua" to 67,"Erlang" to 73,"Kotlin" to 92)
        //求并集
        Log.e("fxj","map5:"+(map+bMap))
        //集合相减
        Log.e("fxj","map6:"+(map-bMap))
    }

    //三、遍历Map
    fun traverseMap(){

        //Map集合由多个key-value对组成，因此遍历Map集合时既可以通过对key-value对进行遍历，也可先遍历key，再通过key来获取对应的value进行遍历。


        //创建不可变集合，返回值是Map
        var map = mapOf("Java" to 86, "Kotlin" to 92, "Go" to 76)
        //遍历Map的key-value对，entris元素返回key-value对组成的Set
        for (en in map.entries) {
            Log.e("fxj","map1:"+ "${en.key}->${en.value}")
        }


        //先遍历Map的key，再通过key获取value
        for (key in map.keys) {
            Log.e("fxj","map2:"+ "${key}->${map[key]}")
        }


        //直接用for-in循环遍历Map
        for ((key, value) in map) {
            Log.e("fxj","map3:"+ "${key}->${value}")
        }

        //用Lambda表达式遍历Map
        map.forEach({ println("${it.key}->${it.value}") })

        //用Lambda表达式遍历Map
        map.forEach({
            Log.e("fxj","map4:"+"${it.key}->${it.value}")
        })
    }

    //四、可变的Map
    fun variableMap(){
        /*

        可变的Map为操作key-value对提供了如下方法：

        clear()：清空所有的key-value对。
        put(key:K,value:V)：放入key-value对。如果原来已有key，value将被覆盖。
        putAll(form:Map<out K,V>)：批量放入多个key-value对。
        remove(key:K)：删除key-value对。



        根据键来访问和更新map的简明愈发，可以使用map[key]读取值，使用map[key] = value 设置它们，而不需要调用get和put

        */

        var mutableMap = mutableMapOf("OC" to 96, "PHP" to 3400, "Perl" to 4300, "Ruby" to 5600, "Go" to 5600)
        //以方括号语法放入key-value对
        mutableMap["Swift"] = 9000
        println("mutableMap1:"+mutableMap)

        //以put方法放入key-value对
        mutableMap.put("OC", 8600)
        println("mutableMap2:"+mutableMap)

        //删除key为"PHP"的key-value对
        mutableMap.remove("PHP")
        println("mutableMap3:"+mutableMap)
        println("mutableMap4:"+mutableMap.size)

        //删除所有元素
        mutableMap.clear()
        println("mutableMap5:"+mutableMap)
        println("mutableMap6:"+mutableMap.size)
    }



}