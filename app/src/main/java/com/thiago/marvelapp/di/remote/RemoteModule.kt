package com.thiago.marvelapp.di.remote

import com.thiago.remote.RemoteProject
import com.thiago.remote.endpoint.ApiImplementation
import org.koin.dsl.module

val remoteModule = module{

    single<ApiImplementation>{
        ApiImplementation()
    }

    single<RemoteProject>{
        RemoteProject(get())
    }
}