package com.text.mvvmarchitecture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.text.mvvmarchitecture.database.StudentDatabase
import com.text.mvvmarchitecture.database.StudentEntity
import com.text.mvvmarchitecture.databinding.ActivityMainBinding
import com.text.mvvmarchitecture.repo.StudentRepo
import com.text.mvvmarchitecture.viewModel.StudentViewModelFactory
import com.text.mvvmarchitecture.viewModel.StuentViewModel


class MainActivity : AppCompatActivity() {
    lateinit var dataBinding: ActivityMainBinding
    lateinit var stuentViewModel: StuentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = StudentDatabase.getDatabase(applicationContext).getStudent()
        val repo = StudentRepo(dao)
        stuentViewModel =
            ViewModelProvider(this, StudentViewModelFactory(repo)).get(StuentViewModel::class.java)
        stuentViewModel.getStudent().observe(this, {
            dataBinding.quotes = it.toString()
        })


        dataBinding.btnAddQuote.setOnClickListener {
            val student = StudentEntity(0, "This is", 1222)
            stuentViewModel.insertSudent(student)
        }


    }


}