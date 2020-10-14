package com.example.player.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.player.model.PlayerModel
import com.example.player.repository.Repository

class MainViewModel( private val repository: Repository) : ViewModel() {

    var cover: MutableLiveData<MutableList<PlayerModel>> = MutableLiveData()

    init { getSongs() }

    fun getSongs() {
        cover = repository.getSongs()
        Log.d("cover", cover.value.toString())
    }
}