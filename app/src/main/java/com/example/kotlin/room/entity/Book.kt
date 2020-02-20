package com.example.kotlin.room.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity
data class Book (
    @PrimaryKey(autoGenerate = true)
    var uid: Int?,
    @ColumnInfo(name = "name")
    var b_name: String?,
    @ColumnInfo(name = "time")
    var b_time: String?,
    @ColumnInfo(name = "userId")
    var b_userId: Long?

)