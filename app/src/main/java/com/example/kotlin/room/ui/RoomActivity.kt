package com.example.kotlin.room.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.kotlin.R
import com.example.kotlin.room.dao.AppDataBase
import com.example.kotlin.room.dao.StudentDao
import com.example.kotlin.room.dao.TeacherDao
import com.example.kotlin.room.entity.Student
import com.example.kotlin.room.entity.Teacher
import kotlinx.android.synthetic.main.activity_room.*

/*

https://www.jianshu.com/p/3e358eb9ac43
Room是一个对象关系映射(ORM)库。Room抽象了SQLite的使用，可以在充分利用SQLite的同时访问流畅的数据库。

https://blog.csdn.net/u014620028/article/details/90719716

https://blog.csdn.net/u014620028/article/details/90719716

https://www.jianshu.com/p/3e358eb9ac43

*/

class RoomActivity : AppCompatActivity() {
    private lateinit var sDao: StudentDao
    private lateinit var tDao: TeacherDao

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

        insert.setOnClickListener {
            insert()
        }

        update.setOnClickListener {
            update()
        }

        delete.setOnClickListener {
            delete()
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


        var s_1 = Student(1, "s1", "小学")
        var s_2 = Student(2, "s2", "小学")
        var s_3 = Student(3, "s3", "小学")
        var s_6 = Student(6, "s6", "大学")
        var s_5 = Student(5, "s5", "大学")
        var s_4 = Student(4, "s4", "大学")

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

    //Update(更新)
    private fun update() {
        //注意，这里我用的是insert，而不是 update
        sDao.insert(Student(1, "s1", "大学～～～～～"))

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
        var s_6 = Student(6, "s6", "大学")
        sDao.deleteSome(Student(100, "s100", "高中"), s_6)

        var sList_select_3: MutableList<Student> = sDao.getAllStudents()
        for (i in sList_select_3.indices) {
            Log.e("room", sList_select_3.get(i).toString())
        }
    }

    private fun insertT() {


        var t_1 = Teacher(1, "t1", 10)
        var t_2 = Teacher(2, "t2", 5)
        var t_3 = Teacher(3, "t3", 3)
        var t_4 = Teacher(4, "t4", 14)
        var t_5 = Teacher(5, "t5", 22)

        var tList: MutableList<Teacher> = mutableListOf<Teacher>()
        tList.add(t_1)
        tList.add(t_2)
        tList.add(t_3)
        tList.add(t_4)
        tList.add(t_5)

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
}