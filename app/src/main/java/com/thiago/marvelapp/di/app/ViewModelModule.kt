package com.thiago.marvelapp.di.app

import com.thiago.marvelapp.mapper.EntityMapper
import com.thiago.marvelapp.viewmodel.HeroesViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

//val viewModelModule = module{
//
//    single<EntityMapper>{
//        EntityMapper()
//    }
//
//    viewModel(){
//        HeroesViewModel(androidApplication(), get(), get())
//    }
//}