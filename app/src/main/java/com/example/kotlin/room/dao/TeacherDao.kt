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

    @Query("select * from Teacher order by t_year desc ")
    fun getAllByDateDesc():MutableList<Teacher>

    @Query("delete from Teacher")
    fun deleteAll()

}