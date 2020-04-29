package com.example.kotlin.designpatterns.builder

class Student(
    val model: String?,
    val year: Int
) {
    private constructor(builder: Builder) : this(builder.model, builder.year)

    class Builder {
        var model: String? = null
        var year: Int = -1

        fun build() = Student(this)
    }

    companion object {
        inline fun build(block: Builder.() -> Unit) = Builder().apply(block).build()
    }
}
