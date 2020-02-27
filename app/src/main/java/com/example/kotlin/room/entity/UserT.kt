package com.example.kotlin.room.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class UserT(


    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    @ColumnInfo(name = "s_name")
    var firstName: String?,
/*

    在Entity中创建自定义类型字段(Embedded)。

    注意：在Entity中创建自定义类型字段，并不意味着，你可以在Entity中创建另一种Entity类型字段。Room，明令禁止多个Entity之间的相互嵌套！

    有时候，我们可能想要在Entity中创建一个自定义字段，比如，在User类中，再加一个Address类(非Entity)的字段。那么，该怎么办呢？很简单，Room提供了一个注解@Embedded。只需要在自定义类型的字段的上一行，添加该注解即可
    */

    @Embedded
    var address: Address?


)