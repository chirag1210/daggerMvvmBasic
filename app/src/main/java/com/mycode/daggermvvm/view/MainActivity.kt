package com.mycode.daggermvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mycode.daggermvvm.R
import com.mycode.daggermvvm.component
import com.mycode.daggermvvm.viewmodel.MainViewModel
import com.mycode.daggermvvm.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var factory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)

        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        viewModel.liveData.observe(this, Observer { name ->
            tvFullName.text = name
        })
    }

    override fun onStart() {
        super.onStart()
        btnSearch.setOnClickListener {
            viewModel.searchUser(edUserName.text.toString())
        }
    }
}