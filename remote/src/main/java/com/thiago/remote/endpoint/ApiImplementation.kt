package com.thiago.remote.endpoint

import com.thiago.remote.service.ServiceApi

class ApiImplementation {

    private val serviceApi: ServiceApi

    init{
        serviceApi = ServiceApi()
    }

    val SERVICE: ApiEndpoint by lazy {
        serviceApi.getDataService().create(ApiEndpoint::class.java)
    }
}