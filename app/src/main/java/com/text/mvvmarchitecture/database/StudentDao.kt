package com.text.mvvmarchitecture.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {
  @Insert
 suspend fun insetStudent(studentEntity: StudentEntity)

 @Query("SELECT * from studentEntity")
  fun getStudent(): LiveData<List<StudentEntity>>


}