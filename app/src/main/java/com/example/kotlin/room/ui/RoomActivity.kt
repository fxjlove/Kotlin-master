package com.example.kotlin.room.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.kotlin.R
import com.example.kotlin.room.dao.AppDataBase
import com.example.kotlin.room.dao.BookDao
import com.example.kotlin.room.dao.StudentDao
import com.example.kotlin.room.dao.TeacherDao
import com.example.kotlin.room.entity.Book
import com.example.kotlin.room.entity.Student
import com.example.kotlin.room.entity.Teacher
import kotlinx.android.synthetic.main.activity_room.*

/*

Room是一个持久性数据库。 https://www.jianshu.com/p/cfde3535233d



https://www.jianshu.com/p/3e358eb9ac43
Room是一个对象关系映射(ORM)库。Room抽象了SQLite的使用，可以在充分利用SQLite的同时访问流畅的数据库。

https://blog.csdn.net/u014620028/article/details/90719716

https://www.jianshu.com/p/3e358eb9ac43

*/

class RoomActivity : AppCompatActivity() {
    private lateinit var sDao: StudentDao
    private lateinit var tDao: TeacherDao
    private lateinit var bDao: BookDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
/*
                Room官方文档介绍 https://developer.android.com/training/data-storage/room/

                Room由三个重要的组件组成：Database、Entity、DAO。

                Entity：代表数据库中某个表的实体类。

                DAO：包含用于访问数据库的方法。
       */

        sDao = AppDataBase.instance.getStudentDao()
        tDao = AppDataBase.instance.getTeacherDao()
        bDao = AppDataBase.instance.getBookDao()

        insert.setOnClickListener {
            insert()
        }

        update.setOnClickListener {
            update()
        }

        delete.setOnClickListener {
            delete()
        }
        query.setOnClickListener {
            query()
        }
        add.setOnClickListener {
            add()
        }


        insertT.setOnClickListener {
            insertT()
        }
        //对教师数据进行排序（按照教学年限）
        sortT.setOnClickListener {
            sortTeacher()
        }

        //现在，要对 ID=1 的老师做修改，把他的教学年限，改成11
        modificationT.setOnClickListener {
            modificationT()
        }

        updateT.setOnClickListener {
            updateT()
        }

        queryT.setOnClickListener {
            queryT()
        }

        deleteT.setOnClickListener {
            deleteT()
        }


        insertB.setOnClickListener {
            insertB()
        }


    }

    //Insert(插入)
    private fun insert() {
        /*
         当DAO里面的某个方法添加了@Insert注解。Room会生成一个实现，将所有参数插入到数据库中的一个单个事务。

               @Insert注解可以设置一个属性：

        onConflict：默认值是OnConflictStrategy.ABORT，表示当插入有冲突的时候的处理策略。OnConflictStrategy封装了Room解决冲突的相关策略：
               1. OnConflictStrategy.REPLACE：冲突策略是取代旧数据同时继续事务。

               2. OnConflictStrategy.ROLLBACK：冲突策略是回滚事务。

               3. OnConflictStrategy.ABORT：冲突策略是终止事务。

               4. OnConflictStrategy.FAIL：冲突策略是事务失败。

               5. OnConflictStrategy.IGNORE：冲突策略是忽略冲突。
*/


        var s_1 = Student(1, "s1", "小学",1)
        var s_2 = Student(2, "s2", "小学",1)
        var s_3 = Student(3, "s3", "小学",1)
        var s_6 = Student(6, "s6", "大学",1)
        var s_5 = Student(5, "s5", "大学",1)
        var s_4 = Student(4, "s4", "大学",1)

        var sList: MutableList<Student> = mutableListOf<Student>().apply {
            add(s_1)
            add(s_2)
            add(s_3)
            add(s_6)
            add(s_5)
            add(s_4)

        }

        //可以直接把list传进去，也可以一个一个单独添加
        sDao.insertAll(sList)

        var sList_select_1: MutableList<Student> = sDao.getAllStudents()

        for (i in sList_select_1.indices) {
            Log.e("room", sList_select_1.get(i).toString())
        }




    }
    //Query(查询)
    private fun query() {
        var sList_select_name: MutableList<Student> = sDao.getStudentName("s2")

        for (i in sList_select_name.indices) {
            Log.e("room", sList_select_name.get(i).toString())
        }

        var sList_select_id: Student = sDao.getStudnetId(5)

        Log.e("room", sList_select_id.toString())
    }

    //Update(更新)
    private fun update() {
        //注意，这里我用的是insert，而不是 update
        sDao.insert(Student(1, "s1", "大学～～～～～",1))

        var sList_select_2: MutableList<Student> = sDao.getAllStudents()

        for (i in sList_select_2.indices) {
            Log.e("room", sList_select_2.get(i).toString())
        }

    }

    //Delete(删除) 从删除可以看出，删除不存在的Student数据，不会报错，只是没有效果，删除存在的数据，就是正常删除
    private fun delete() {
        /*
         当DAO里面的某个方法添加了@Delete注解。Room会把对应的参数信息指定的行删除掉(通过参数里面的primary key找到要删除的行)。

       @Delete也是可以设置onConflict来表明冲突的时候的解决办法。

        @Delete对应的方法也是可以设置int返回值来表示删除了多少行。
    */
        var s_6 = Student(6, "s6", "大学",1)
        sDao.deleteSome(Student(100, "s100", "高中",1), s_6)

        var sList_select_3: MutableList<Student> = sDao.getAllStudents()
        for (i in sList_select_3.indices) {
            Log.e("room", sList_select_3.get(i).toString())
        }
    }
    //新增age字段
    private fun add(){
        //可以直接把list传进去，也可以一个一个单独添加
        var s_7 = Student(7, "s7", "大学7",7)
        sDao.insert(s_7)

        var sList_select_1: MutableList<Student> = sDao.getAllStudents()

        for (i in sList_select_1.indices) {
            Log.e("room", sList_select_1.get(i).toString())
        }
    }

    private fun insertT() {


        var t_1 = Teacher(1, "t1", 10)
        var t_2 = Teacher(2, "t2", 5)
        var t_3 = Teacher(3, "t3", 3)
        var t_4 = Teacher(4, "t4", 14)
        var t_5 = Teacher(5, "t5", 22)

        var tList: MutableList<Teacher> = mutableListOf<Teacher>().apply {
            add(t_1)
            add(t_2)
            add(t_3)
            add(t_4)
            add(t_5)
        }


        tDao.insertAll(tList)

        var tList_select_1: MutableList<Teacher> = tDao.getAllTeachers()

        for (i in tList_select_1.indices) {
            Log.e("room", tList_select_1.get(i).toString())
        }

    }

    //对教师数据进行排序（按照教学年限）
    private fun sortTeacher() {
        var tList_select_2: MutableList<Teacher> = tDao.getAllByDateDesc()

        for (i in tList_select_2.indices) {
            Log.e("room", tList_select_2.get(i).toString())
        }
    }

    //现在，要对 ID=1 的老师做修改，把他的教学年限，改成11，还是用之前Student的那种写法：
    private fun modificationT() {
        //    @Insert 报错  如果没有这个注解，插入已有数据，会报错！如果有这个注解，插入以后数据，仅仅是替换。
        //    改成
        //    @Insert(onConflict = OnConflictStrategy.REPLACE)
        tDao.insert(Teacher(1, "t1", 11))

        var tList_select_1: MutableList<Teacher> = tDao.getAllTeachers()


        for (i in tList_select_1.indices) {
            Log.e("room", tList_select_1.get(i).toString())
        }
    }

    //todo Update(更新)
    private fun updateT() {
/*

         当DAO里面的某个方法添加了@Delete注解。Room会把对应的参数信息指定的行删除掉(通过参数里面的primary key找到要删除的行)。

               @Delete也是可以设置onConflict来表明冲突的时候的解决办法。

               @Delete对应的方法也是可以设置int返回值来表示删除了多少行。
*/
        tDao.update(Teacher(1, "t1", 1111))

        var tList_select_3: MutableList<Teacher> = tDao.getAllTeachers()

        for (i in tList_select_3.indices) {
            Log.e("room", tList_select_3.get(i).toString())
        }


    }

    //查询语句中传参
    private fun queryT(){
        //只展示大于某个年龄的user.
        var tList_select: MutableList<Teacher> = tDao.getTeacher2(10)
        for (i in tList_select.indices) {
            Log.e("room", tList_select.get(i).toString())
        }

        Log.e("room","~~~~~~~~~~~~~~~~~~~~~")

        var tList_select_between: MutableList<Teacher> = tDao.loadAllUsersBetweenAges(10,22)
        for (i in tList_select_between.indices) {
            Log.e("room", tList_select_between.get(i).toString())
        }

        Log.e("room","~~~~~~~~~~~~~~~~~~~~~")

        var tList_select_name: MutableList<Teacher> = tDao.findUserWithName("t4","t5")
        for (i in tList_select_name.indices) {
            Log.e("room", tList_select_name.get(i).toString())
        }

        Log.e("room","~~~~~~~~~~~~~~~~~~~~~")

/*
        Room明白: 查询返回了列first_name和last_name, 这些值能够映射到NameTuple为的域中.

        由此, Room能够产生适当的代码. 如果查询返回了太多列, 或者返回了NameTuple类中并不存在的列, Room将展示警告信息.
        备注: POJO也可以使用@Embedded注解.*/
        var tList_select_name2: MutableList<Teacher> = tDao.findUserWithName2()
        for (i in tList_select_name2.indices) {
            Log.e("room", tList_select_name2.get(i).toString())
        }







    }
    //delete（删除）
    private fun deleteT(){
        tDao.deleteAll()

    }

    private fun insertB(){
        var t_1 = Book(1, "t1", "时间1",11)
        var t_2 = Book(2, "t2", "时间2",22)
        var t_3 = Book(3, "t3", "时间3",33)
        var t_4 = Book(4, "t4", "时间4",44)

        var tList: MutableList<Book> = mutableListOf<Book>().apply {
            add(t_1)
            add(t_2)
            add(t_3)
            add(t_4)
        }


        bDao.insertAll(tList)

        var tList_select_1: MutableList<Book> = bDao.getAllTeachers()

        for (i in tList_select_1.indices) {
            Log.e("room", tList_select_1.get(i).toString())
        }
    }

}