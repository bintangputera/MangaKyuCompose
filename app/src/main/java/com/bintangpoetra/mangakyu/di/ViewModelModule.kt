package com.bintangpoetra.mangakyu.di

import com.bintangpoetra.mangakyu.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { HomeViewModel(get(), get()) }

}