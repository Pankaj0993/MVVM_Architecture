package com.text.mvvmarchitecture.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.text.mvvmarchitecture.repo.StudentRepo

class StudentViewModelFactory(private val studentRepo: StudentRepo): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StuentViewModel(studentRepo) as T
    }
}