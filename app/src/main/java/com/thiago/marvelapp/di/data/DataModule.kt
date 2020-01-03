package com.thiago.marvelapp.di.data

import com.thiago.data.DataProject
import com.thiago.data.repository.DataRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module{

    single<DataRepository>{
        DataRepository(androidContext(), get())
    }

    single<DataProject>{
        DataProject(get())
    }
}