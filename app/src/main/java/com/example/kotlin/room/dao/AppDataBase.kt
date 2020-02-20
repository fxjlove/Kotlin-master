package com.example.kotlin.room.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import com.example.kotlin.room.entity.Student
import com.example.kotlin.room.entity.Teacher
import com.example.kotlin.ui.MyApplication
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.migration.Migration
import com.example.kotlin.room.entity.Book


@Database(entities = [Student::class, Teacher::class, Book::class], version = 3)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getStudentDao(): StudentDao

    abstract fun getTeacherDao(): TeacherDao

    abstract fun getBookDao(): BookDao


    companion object {

        val instance = Single.sin

    }

    private object Single {
        /**
         * 数据库版本 1->2 Student表格新增了age列
         */
        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Student " + " ADD COLUMN s_age INTEGER")
            }
        }

        /**
         * 数据库版本 2->3 新增book表格
         */
        val MIGRATION_2_3: Migration = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                //Migrating使用过程中也有碰到一些坑，这里告诫大家一个经验Entity中能用Integer的时候不用int。
                database.execSQL(
                    "CREATE TABLE IF NOT EXISTS `book` (`uid` INTEGER PRIMARY KEY autoincrement, `name` TEXT , `userId` INTEGER, 'time' TEXT)"
                )


               /* //创建表
                database.execSQL(
                    "CREATE TABLE student_new (student_id TEXT, student_name TEXT, phone_num INTEGER, PRIMARY KEY(student_id))");
                //复制表
                database.execSQL(
                    "INSERT INTO student_new (student_id, student_name, phone_num) SELECT student_id, student_name, phone_num FROM student");
                //删除表
                database.execSQL("DROP TABLE student");
                //修改表名称
                database.execSQL("ALTER TABLE student_new RENAME TO students");*/
            }
        }

        val sin :AppDataBase= Room.databaseBuilder(
            MyApplication.instance(), AppDataBase::class.java, "User.db")
            .allowMainThreadQueries()
            .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
            .build()


    }



}