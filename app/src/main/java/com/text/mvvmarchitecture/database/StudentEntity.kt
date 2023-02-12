package com.text.mvvmarchitecture.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "studentEntity")
data class StudentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val password: Int
)
