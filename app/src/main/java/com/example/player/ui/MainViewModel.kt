package com.example.player.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.player.model.PlayerModel
import com.example.player.repository.Repository

class MainViewModel( private val repository: Repository) : ViewModel() {



    fun getSongs(): MutableLiveData<MutableList<PlayerModel>> {
        return repository.getSongs()
    }
}