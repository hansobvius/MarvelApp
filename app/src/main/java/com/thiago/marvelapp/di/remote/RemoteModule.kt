package com.thiago.marvelapp.di.remote

import com.thiago.remote.endpoint.ApiImplementation
import org.koin.dsl.module

val remoteModule = module{

    single<ApiImplementation>{
        ApiImplementation()
    }
}