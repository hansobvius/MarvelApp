package com.thiago.marvelapp.di

import com.thiago.data.DataProject
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val mainModule = module{

    single<DataProject>{
        DataProject(androidContext())
    }
}