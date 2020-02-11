package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.inherit.lambda.Book
import com.example.kotlin.inherit.lambda.Person
import kotlinx.android.synthetic.main.activity_other.*
import java.io.File

/**
 * Lambda
 */
class LambdaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        /*Java 匿名内部类实现监听器 */
       /* button.setOnClickListener(new OnClickListener(){
            override
            public void onClick(View view){
                <!-- 点击后执行的动作-->
            }
         }
        );*/
       /* Kotlin的Lambda表达式来替换匿名内部类*/

       /* button.setOnClickListener{<!--点击后执行的动作-->}*/


        lambdaAndList()

        member()

        gather()

        gatherFunction()

        groupBy()

        flatMapAndFlatten()

        lazyCollectionOperation()

        performSequentialOperations()

        createSequential()

        javaFun()

        passParameter()

    }
    //todo Lambda和集合  https://www.jianshu.com/p/cb196a2b0a66
    fun lambdaAndList(){
        println("Lambda和集合～～～～～～～～～～～～～")

        val people = listOf(
            com.example.kotlin.inherit.lambda.Person("AA",20),
            com.example.kotlin.inherit.lambda.Person("BB",24)
        )

        //手动在集合中搜索
        findTheOldest(people)

        //用lambda在集合中搜索
        //maxBy函数可以在任何集合上调用，而且只需要一个实参：一个函数，指定比较哪个值来找到最大元素
        var p = people.maxBy { it.age }//比较年龄找到最大的元素
        println(p?.name)

        //如果lambda刚好是属性的委托，可以用成员引用代替
        //用成员引用搜索
//        var p2 = people.maxBy {Person::age }//比较年龄找到最大的元素

        /*

            Lambda表达式语句

            {x: Int, y: Int -> x+y}

            x: Int, y: Int 参数 实参

            x+y 函数体

            x: Int, y: Int -> x+y 始终在花括号内


            Kotlin的lambda表达式始终用花括号包围，注意：实参并没有用括号扩起来，箭头把实参列表和lambda的函数体隔开

        */

        //可以把lambda表达式存储在一个变量中，把这个变量当作普通函数对待（即：通过相应实参调用它）
        val sum = { x: Int , y: Int -> x+y }
        println(sum(1,2))//调用保存在变量中的 lambda

        //直接调用lambda表达式 { println(42) }  使用库函数run来执行传给它的lambda
        run { println(42) }//运行lambda中的代码



        var p2 = people.maxBy { it.age }//比较年龄找到最大的元素
        println(p2?.name)


        people.maxBy({ p: com.example.kotlin.inherit.lambda.Person -> p.age })

        //如果lambda表达式是函数调用的最后一个实参，它可以放到括号的外边，这个例子中，lambda是唯一的实参，所有可以放到括号的后边
        people.maxBy() { p: com.example.kotlin.inherit.lambda.Person -> p.age }

        //当lambda是函数唯一的实参时，还可以去掉调用代码中的空括号对
        people.maxBy { p: com.example.kotlin.inherit.lambda.Person -> p.age }



        println("把lambda作为命名实参传递~~~~~~~~~~")
        //把lambda作为命名实参传递
        val names = people.joinToString(separator = " ",transform =  { p: com.example.kotlin.inherit.lambda.Person -> p.name} )
        println(names)

        //把lambda放在括号外
        val names2 = people.joinToString(" ") { p: com.example.kotlin.inherit.lambda.Person -> p.name }
        println(names2)


        //省略lambda参数类型
         people.maxBy { p: com.example.kotlin.inherit.lambda.Person -> p.age }//显式地写出参数类型
         people.maxBy { p -> p.age }//推导出参数类型

         people.maxBy {it.age }// it 是自动生成的参数名  仅在实参名称没有显示地指定时这个默认的名称才会生成

        //如果你用变量存储lambde,那么就没有可以推断出参数类型的上文，所有你必须显示地指定参数类型
        val getAge = {p: com.example.kotlin.inherit.lambda.Person -> p.age}
        people.maxBy(getAge)





    }
    //找到列表中年龄最大的那个人

    //手动在集合中搜索
    fun findTheOldest(people: List<com.example.kotlin.inherit.lambda.Person>){
        //储存最大年龄
        var maxAge = 0
        //储存年龄最大的人
        var theOldest: com.example.kotlin.inherit.lambda.Person? = null
        for (person in people){
            if (person.age > maxAge){
                maxAge = person.age
                theOldest = person
            }
        }
        println(theOldest?.name)

    }
    //todo 成员引用
    fun member(){
        println("成员引用~~~~~~~~~~~~~~~~~~")
        val list = listOf(
            com.example.kotlin.inherit.lambda.Person("AA",20),
            com.example.kotlin.inherit.lambda.Person("BB",24)
        )

        //如果你想要当做参数传递的代码已经被定义成了函数，那么你可以将这个函数转换成值，如下使用::运算符来转换


        //把函数转换成一个值，你就可以传递它，使用 :: 运算符来转换
        val getAge = Person :: age

        //这种表达式被称为成员引用，它提供简明语法，来创建一个调用单个方法或这访问单个属性的函数值。双冒号把类名称和你要引用的成员名称隔开
        /*

           Person :: age

           Person  类

           age     成员


           ::     用双冒号隔开



        */


        val getAge1 = { person: Person  -> person.age}  //lambda表达式

        //成员引用和调用函数的lambda具有一样的类型，所以可以相互转换
        list.maxBy(Person::age)

        //还可以引用顶层函数(不是类的成员)，这种情况省略了类名称，直接以::开头。成员引用::salute被当作实参传递给库函数run
        fun salute() = println("Salute!")
        run(::salute)//引用顶层函数


        //如果lambda要委托给一个接收多个参数的函数，提供成员引用代替它将会非常方便
        val action = {person:Person,message:String ->  //这个lambda委托给sendEmail函数
            sendEmail(person,message)}

        val nextAction = ::sendEmail  //可以用成员引用代替
        //调用
        val p = Person("AA",20)
        nextAction(p,"啦啦啦")


        //可以用构造方法引用存储或者延期执行创建类实例的动作，构造方法的引用方式是在双冒号后指定类名称

        val createPerson = ::Person   //创建`Person`实例的动作被保存成了值
        val person = createPerson("kdp",25)
        println(person.name)

        //还可以使用同样的方式引用扩展函数
//        val predicate = Person::isAdult
        //尽管isAdult不是Person类的成员，还是可以通过引用访问它，这和访问实例的成员没什么两样：person.isAudlt()
        person.isAdult()


        //绑定引用  Kotlin1.1允许你使用成员引用语法捕捉特定实例对象上的方法引用
        val p1 = Person("Dmitry",34)
        val personsAgeFunction = Person::age
        println(personsAgeFunction(p))
        //在kotlin1.1中可以使用绑定成员引用
        val dmitrysAgeFunction = p1::age
        println(dmitrysAgeFunction())

    }
    fun sendEmail(person:Person,message:String){

    }

    fun Person.isAdult() = age >= 21


    //todo 集合的函数式API  https://www.jianshu.com/p/99e164fbee51
    fun gather(){
        println("集合的函数式API～～～～～～～～～～～～～")
        //1.基础： filte  和 map   filte  和 map形成了集合操作的基础

        //filter函数遍历集合并选出应用给定lambda后会返回true的哪些元素
        val  list = listOf(1,2,3,4)
        println(list.filter { it % 2 == 0 })//只有偶数留下来


        //filter函数选出了匹配给定判断式的元素
        val personList = listOf(com.example.kotlin.inherit.lambda.Person("AA",29), com.example.kotlin.inherit.lambda.Person("BB",31))
        println(personList.filter { it.age > 30})  //留下哪些超过30岁的人

        //filter函数可以从i 和中移除你不想要的元素，但是它并不会改变这些元素，元素的变换式map的用武之地
        //map函数对集合中的每一个元素应用给定的函数并把结果收集到一个新的集合


        //数字列表变成它的平方列表
        println(list.map { it * it })



        //map对集合中的每个元素都应用lambda
        println(personList.map { it.name })
        //这个例子可以用成员引用漂亮地重写：
        personList.map(Person::name)
        println("成员引用："+ personList.map(Person::name) )

        //打印出年龄超过30岁的人的名字：

        val name = personList.filter { it.age > 30 }.map(Person::name)
        println("名字："+ name )

        //年龄最大的人的名字
        val name2 =  personList.filter { it.age == personList.maxBy(Person::age)?.age ?: "" }
        println("名字2："+ name2 )
        //只计算了一次最大年龄
        val maxAge = personList.maxBy(Person::age)!!.age
        personList.filter { it.age == maxAge }


        //对map应用应用和变换函数
        val numbers = mapOf(0 to "zero",1 to "one")
        println(numbers.mapValues { it.value.toUpperCase() })
        //键和值分别有各自的函数来出了 filterKeys和mapKeys过滤和变换map的键，而另外的filterValues和mapValues过滤和变换对应的值

    }
    //all any  count  find ：对集合应用判断式
    fun gatherFunction(){
        println("all any  count  find ：对集合应用判断式～～～～～～～～～～～～～")
        /*
            all any函数: 检查集合中的所有元素是否都符合某个条件（或者他的变种，是否存在符合的元素）

            count函数 ： 检查有多少元素满足判断式

            find函数 : 返回第一个符合条件的元素
        */

        val canBeInClub27 = {p: Person -> p.age <= 27}
        val personList = listOf(com.example.kotlin.inherit.lambda.Person("AA",27), com.example.kotlin.inherit.lambda.Person("BB",31))
        //如果你对是否所有元素都满足判断式感兴趣，应该使用all函数
        println(personList.all(canBeInClub27))
        //如果你需要检查集合中是否至少存在一个匹配的元素，那就用any
        println(personList.any(canBeInClub27))


        val list = listOf(1,2,3)
        println(!list.all { it == 3 }) // !否定不明显，这种清空最好使用 any   （1）
        println(list.any { it != 3 })  // lambda参数中的条件要取反           （2）
        //（1）是保证不是所有的元素都等于3 ，这和至少有一个元素不是3是一个意思，这正是（2）用any做的检查


        //如果你想知道有多啊手啊个元素满足了判断式，使用count
        println(personList.count(canBeInClub27))

        println(personList.filter(canBeInClub27).size)



        //要找到一个满足判断式的元素，使用find函数
        println(personList.find(canBeInClub27))
        //如果有多个匹配的元素就返回其中第一个元素，或者返回null,如果没有一个元素能满足判断式，find还有一个同义方法 firstOrNull
    }
    //todo groupBy:把列表转换成分组的map
    fun groupBy(){
        println("groupBy:把列表转换成分组的map～～～～～～～～～～～～～")

        val personList = listOf(com.example.kotlin.inherit.lambda.Person("AA",31),Person("BB",27), com.example.kotlin.inherit.lambda.Person("CC",31))
        //相同年龄的人放在一组
        println(personList.groupBy { it.age })

        //使用成员引用把字符串按照首字母分组
        val list = listOf("a","ab","b")
        println(list.groupBy( String::first ))
        //注意：这里first并不是String类的成员，而是一个扩展，然而，可以把它当作成员引用访问

    }
    //todo flatMap 和 flatten:处理嵌套集合中的元素
    fun flatMapAndFlatten(){
        println("flatMap 和 flatten:处理嵌套集合中的元素～～～～～～～～～～～～～")
        val books = listOf(Book("AA", listOf("小张")),Book("BB", listOf("小李")),Book("CC", listOf("小张","小红")))

        //包含写books集合中书籍的所有作者的set
        println(books.flatMap { it.authors }.toSet())//[小张, 小李, 小红]

        val strings = listOf("abc","def")
        println(strings.flatMap { it.toList() })//[a, b, c, d, e, f]
    }

    //todo 惰性集合操作：序列  https://www.jianshu.com/p/99e164fbee51
    fun lazyCollectionOperation(){
        println("惰性集合操作：序列～～～～～～～～～～～～～")
        val personList = listOf(com.example.kotlin.inherit.lambda.Person("AA",31),Person("BB",27), com.example.kotlin.inherit.lambda.Person("CC",31))
        println(personList.map (Person::name ).filter { it.startsWith("A") })
        //上面的例子中map和filter都会返回一个列表，也就是说链式的调用会创建两个列表:一个保存filter函数的结果，另一个保存map函数的结果，如果源列表中只有两个元素，这不是什么问题，但如果有一百万个元素，(链式)调用就会变得十分低效。

        //为提高效率，可以把操作变成使用序列，而不是直接使用集合
        personList.asSequence() //把初始集合转换成序列
            .map(Person::name)  //序列支持和集合一样的API
            .filter { it.startsWith("A") }  //序列支持和集合一样的API
            .toList()   //把结果序列转换成列表

        //Kotlin惰性集合操作的入口就是Sequence接口，它的强大之处就在于其操作的实现方式，序列中元素的求值是惰性的。因此可以使用序列高效地对集合元素执行链式操作，而不需要创建额外的集合来保存过程中产生的中间结果。
        //可以调用扩展函数asSequence把任意集合转换成序列，调用toList来做反向的转换


    }
    //todo 执行序列操作 : 中间和末端操作
    fun performSequentialOperations(){
        println("执行序列操作 : 中间和末端操作～～～～～～～～～～～～～")
/*

        序列操作分为两类：中间和末端。一次中间操作返回的是另一个序列，这个新序列知道如何变换原始序列中的元素。而一次末端操作返回的是一个结果，这个结果可能是集合、蒜素、数字，后者其他从出事集合的变换序列中获取的任意对象

        sequence.map{...}.filter{...}.toList()

        map{...}  ilter{...} 中间操作

        toList()末端操作


*/

        //中间操作始终是惰性的，看看下面这个缺少了末端操作的例子
        listOf(1,2,3,4).asSequence()
            .map{print("map ($it)");it * it}
            .filter { print("filter($it)");it % 2 == 0 }
            .toList()


        val personList = listOf(com.example.kotlin.inherit.lambda.Person("AAAA",31),Person("BB",27), com.example.kotlin.inherit.lambda.Person("CCCCCC",31),Person("DDDD",11))

        println(personList.asSequence().map(Person::name).filter { it.length < 4 }.toList())//先 map 后 filter

        println(personList.asSequence().filter { it.name.length < 4 }.map(Person::name).toList())//先 filter 后 map

        //先应用filter有助于减少变换的总次数  如果map在前，每个元素都会被变换，而如果filter在前，不合适的元素会被尽早地过滤掉且不会发生变换
    }
    //todo 创建序列
    fun createSequential(){
        println("创建序列～～～～～～～～～～～～～")
        /*

        使用generateSequence函数创建序列，给定序列中的前一个元素，这个函数会计算下一个元素

        */
        //生成并使用自然数序列

        val naturalNumbers = generateSequence(0){it+1}
        val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
        println(numbersTo100.sum()) //在获取结果`sum`时，所有被推迟的操作都被执行

/*
        创建并使用父目录的序列

        创建使用父目录的序列，如果元素的父元素和它的类型相同，你可能会对它的祖先组成的序列的物质感兴趣。下面的例子可以查询文件是否放在隐藏目录中，通过创建一个其父目录的序列并检查每个目录的属性来实现
        */
        val file = File("/Users/svtk/.HiddenDir/a.txt")
        println(file.isInsideHidenDirectory())


    }
    fun File.isInsideHidenDirectory()=
            generateSequence(this) { it.parentFile }.any { it.isHidden }



    //todo 使用Java函数式接口
    fun javaFun(){
        println("使用Java函数式接口～～～～～～～～～～～～～")

        tv_01.setOnClickListener { /*点击之后的动作*/ }

        tv_01.setOnClickListener { view -> /*点击之后的动作*/  }


    }
    //todo 把lambda当作参数传递给java方法
    fun passParameter(){
        println("把lambda当作参数传递给java方法～～～～～～～～～～～～～")

        


    }

}