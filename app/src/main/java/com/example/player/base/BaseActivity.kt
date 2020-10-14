package com.example.player.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel

abstract class BaseActivity<ViewModel : BaseViewModel>(
        private val layoutID:Int):AppCompatActivity()  {


    protected abstract val viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutID)
        setUpListeners()

    }
    abstract fun setUpListeners()

}