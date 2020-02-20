package com.example.kotlin.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.kotlin.room.entity.Student

@Dao
interface StudentDao:BaseDao<Student> {

    //当DAO里面的某个方法添加了@Insert注解。Room会生成一个实现，将所有参数插入到数据库中的一个单个事务。
    //当@Insert注解的方法只有一个参数的时候，这个方法也可以返回一个long，当@Insert注解的方法有多个参数的时候则可以返回long[]或者r List<Long>。long都是表示插入的rowId。
    //OnConflictStrategy.REPLACE：冲突策略是取代旧数据同时继续事务。
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(element:Student)

    // 查询所有的信息
    @Query("select * from Student")
    fun getAllStudents():MutableList<Student>

    //带参数的查询
    @Query("SELECT * FROM Student WHERE s_name == :name")
    fun getStudentName(name: String):MutableList<Student>

    @Query("select * from Student where studentID = :studentID")
    fun getStudnetId(studentID:Int):Student

    //多个参数查询
//    @Query("SELECT * FROM Student WHERE age BETWEEN :minAge AND :maxAge")
//    fun loadAllUsersBetweenAges(minAge: Int, maxAge: Int): Array<Student>
//
//    @Query("SELECT * FROM user WHERE firstName LIKE :search " + "OR lastName LIKE :search")
//    fun findUserWithName(search: String): List<Student>


    @Query("select * from Student order by studentID desc ")
    fun getAllByDateDesc():MutableList<Student>

    @Query("delete from Student")
    fun deleteAll()



}