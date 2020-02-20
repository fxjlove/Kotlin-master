package com.example.kotlin.room.dao

import android.arch.persistence.room.*
import com.example.kotlin.room.entity.Book
import com.example.kotlin.room.entity.Teacher
import com.example.kotlin.room.entity.User
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Update






@Dao
interface UserDao:BaseDao<User> {

    //vararg 可变参数

    //增
    @Insert
    fun insert(vararg users: User)

    //删除某一项
    @Delete
    fun delete(vararg users: User)

    //删全部
    @Query("DELETE FROM user")
    fun deleteAll()

    //改
    @Update
    fun update(vararg users: User)

    //查全部
    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>

    //根据字段查询
    @Query("SELECT * FROM User WHERE s_name= :name")
    fun getUserByName(name: String): User


}