package com.text.mvvmarchitecture.repo

import androidx.lifecycle.LiveData
import androidx.room.Entity
import com.text.mvvmarchitecture.database.StudentDao
import com.text.mvvmarchitecture.database.StudentEntity

class StudentRepo(private val studentDao: StudentDao) {

     fun getStudent():LiveData<List<StudentEntity>>{
        return studentDao.getStudent()
    }

    suspend fun insertStudent(studentEntity: StudentEntity){
        return studentDao.insetStudent(studentEntity)
    }
}