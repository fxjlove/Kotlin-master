package com.example.kotlin.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.kotlin.room.entity.Teacher


@Dao
interface TeacherDao:BaseDao<Teacher> {

    @Insert
    fun insert(element:Teacher)

    @Query("select * from Teacher")
    fun getAllTeachers():MutableList<Teacher>

    @Query("select * from Teacher where teacherID = :teacherID")
    fun getTeacher(teacherID:Int):Teacher

    //只展示大于某个年龄的Teacher
    @Query("SELECT * FROM Teacher WHERE t_year >= :minAge")
    fun getTeacher2(minAge: Int):MutableList<Teacher>

    @Query("SELECT * FROM Teacher WHERE t_year BETWEEN :minAge AND :maxAge")
    fun loadAllUsersBetweenAges(minAge:Int, maxAge:Int):MutableList<Teacher>

//    @Query("SELECT * FROM Teacher WHERE first_name LIKE :search " + "OR last_name LIKE :search")
    @Query("SELECT * FROM Teacher WHERE t_name LIKE :search " + "OR t_name LIKE :search2")
    fun findUserWithName(search:String,search2:String):MutableList<Teacher>

    //查询返回了列t_name和t_year, 这些值能够映射到NameTuple为的域中.
    @Query("SELECT t_name, t_year FROM Teacher")
    fun findUserWithName2():MutableList<Teacher>

//    @Query("SELECT first_name, last_name FROM Teacher WHERE region IN (:regions)")
//    fun loadUsersFromRegions(regions: List<String>):MutableList<Teacher>


    @Query("select * from Teacher order by t_year desc ")
    fun getAllByDateDesc():MutableList<Teacher>

    @Query("delete from Teacher")
    fun deleteAll()

}