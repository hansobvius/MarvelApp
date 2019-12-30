package com.thiago.marvelapp.di

import com.thiago.remote.service.ServiceApi
import org.koin.dsl.module

val remoteModule = module{

    single<ServiceApi.Companion>{
        ServiceApi
    }
}