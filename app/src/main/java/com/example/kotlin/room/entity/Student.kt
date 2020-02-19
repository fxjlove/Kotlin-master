package com.example.kotlin.room.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/*
Entity：代表数据库中某个表的实体类。
@Entity注解包含的属性有：

tableName：设置表名字。默认是类的名字。
indices：设置索引。
inheritSuperIndices：父类的索引是否会自动被当前类继承。
primaryKeys：设置主键。
foreignKeys：设置外键。

1.设置表的名字:
 默认情况下Entity类的名字就是表的名字(不区分大小写)。但是我们也可以通过@Entity的tableName属性来自定义表名字。如下代码所示users表对应的实体类。

2.设置列的名字:
默认情况下Entity类中字段的名字就是表中列的名字。我们也是可以通过@ColumnInfo注解来自定义表中列的名字。如下代码users表中first_name列对应firstName字段，last_name列对应lastName字段。

3、设置主键
   每个Entity都需要至少一个字段设置为主键。即使这个Entity只有一个字段也需要设置为主键。Entity设置主键的方式有两种:

   通过@Entity的primaryKeys属性来设置主键(primaryKeys是数组可以设置单个主键，也可以设置复合主键)。
   @Entity(primaryKeys = {"firstName",
                       "lastName"})

   同@PrimaryKey注解来设置主键。
   如果你希望Room给entity设置一个自增的字段，可以设置@PrimaryKey的autoGenerate属性。



4、设置索引
  数据库索引用于提高数据库表的数据访问速度的。数据库里面的索引有单列索引和组合索引。Room里面可以通过@Entity的indices属性来给表格添加索引。
  @Entity(indices = {@Index("firstName"),
        @Index(value = {"last_name", "address"})})

    索引也是分两种的唯一索引和非唯一索引。唯一索引就想主键一样重复会报错的。可以通过的@Index的unique数学来设置是否唯一索引。
    @Entity(indices = {@Index(value = {"first_name", "last_name"},
        unique = true)})


5、设置外键




*/
@Entity(tableName = "Student")
data class Student(
    //primaryKeys：设置主键。
    @PrimaryKey(autoGenerate = true)
    var studentID: Int?,
    @ColumnInfo(name = "s_name")
    var studentName: String?,
    @ColumnInfo(name = "s_type")
    var studentType: String?
)