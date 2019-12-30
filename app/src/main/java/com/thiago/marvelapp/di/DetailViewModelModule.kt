package com.thiago.marvelapp.di

import com.thiago.marvelapp.viewmodel.DetailViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailViewModelModule = module{

    viewModel {
        DetailViewModel(androidApplication())
    }
}
