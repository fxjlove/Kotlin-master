package com.example.kotlin.room.entity

import android.arch.persistence.room.ColumnInfo

data class Address(
    var street: String?,
    var state: String?,
    var city: String?,

    @ColumnInfo(name = "post_code")
    var postCode: Int?

)