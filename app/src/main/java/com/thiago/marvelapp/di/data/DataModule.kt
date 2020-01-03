package com.thiago.marvelapp.di.data

import com.thiago.data.DataProject
import com.thiago.data.mapper.ModelMapper
import com.thiago.data.repository.DataRepository
import org.koin.dsl.module

val dataModule = module{

    single<ModelMapper>{
        ModelMapper()
    }

    single<DataRepository>{
        DataRepository(get(), get(), get())
    }

    single<DataProject>{
        DataProject(get())
    }
}