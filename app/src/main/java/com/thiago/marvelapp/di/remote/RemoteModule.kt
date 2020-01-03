package com.thiago.marvelapp.di.remote

import com.thiago.remote.RemoteProject
import com.thiago.remote.endpoint.ApiImplementation
import com.thiago.remote.service.ServiceApi
import org.koin.dsl.module

val remoteModule = module{

    single<ServiceApi>{
        ServiceApi()
    }

    single<ApiImplementation>{
        ApiImplementation(get())
    }

    single<RemoteProject>{
        RemoteProject(get())
    }
}