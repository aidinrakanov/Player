package com.example.player.di

import com.example.player.network.RetrofitClient
import com.example.player.repository.Repository
import com.example.player.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var playerModule = module {

    single { RetrofitClient().provideSongs() }

    factory { Repository(get()) }

    viewModel { MainViewModel(get()) }


}