package com.example.kotlin.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.kotlin.room.entity.Book
import com.example.kotlin.room.entity.Teacher


@Dao
interface BookDao:BaseDao<Book> {

    @Insert
    fun insert(element:Book)

    @Query("select * from Book")
    fun getAllTeachers():MutableList<Book>



}