package com.example.player.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.player.R
import com.example.player.model.PlayerModel
import com.example.player.ui.player.PlayerActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    private lateinit var mainAdapter: MainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler()
        subscribeSongs()
        setUpListeners()

    }


    private fun recycler() {
        mainAdapter = MainAdapter()
        recycler_main.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainAdapter
        }
    }

    private fun subscribeSongs() {
        viewModel.cover.observe(this, Observer {
            mainAdapter.update(it)
        })
    }

    private fun setUpListeners() {
        mainAdapter.setOnClick(object : MainAdapter.ClickListener {
            override fun click(item: PlayerModel) {
                PlayerActivity.instanceStart(this@MainActivity, item)
            }
        })
    }
}