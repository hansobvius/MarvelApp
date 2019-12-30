package com.thiago.remote.endpoint

import com.thiago.remote.service.ServiceApi

object DataImplementation {

    private val serviceApi: ServiceApi

    init{
        serviceApi = ServiceApi()
    }

    val service: DataEndpoint by lazy {
        serviceApi.getDataService().create(DataEndpoint::class.java)
    }
}