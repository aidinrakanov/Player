package com.example.player.network

import com.example.player.model.PlayerModel
import retrofit2.Call
import retrofit2.http.GET

interface PlayerApi {

    @GET("studio")
    fun getSongs(): Call<MutableList<PlayerModel>>
}