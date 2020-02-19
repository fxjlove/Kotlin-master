package com.example.kotlin.room.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import com.example.kotlin.room.entity.Student
import com.example.kotlin.room.entity.Teacher
import com.example.kotlin.ui.MyApplication


@Database(entities = [Student::class, Teacher::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getStudentDao(): StudentDao

    abstract fun getTeacherDao(): TeacherDao

    companion object {

        val instance = Single.sin

    }

    private object Single {

        val sin :AppDataBase= Room.databaseBuilder(
            MyApplication.instance(),
            AppDataBase::class.java,
            "User.db"
        )
            .allowMainThreadQueries()
            .build()
    }

}