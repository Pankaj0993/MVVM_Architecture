package com.text.mvvmarchitecture.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.text.mvvmarchitecture.database.StudentEntity
import com.text.mvvmarchitecture.repo.StudentRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StuentViewModel(private val studentRepo: StudentRepo): ViewModel() {

    fun getStudent(): LiveData<List<StudentEntity>>{
          return studentRepo.getStudent()
    }

    fun insertSudent(studentEntity: StudentEntity){
        viewModelScope.launch(Dispatchers.IO) {

         studentRepo.insertStudent(studentEntity)
        }
    }
}