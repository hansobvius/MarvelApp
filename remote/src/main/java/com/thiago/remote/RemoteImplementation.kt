package com.thiago.remote

import com.thiago.remote.endpoint.ApiImplementation

interface RemoteImplementation {

    fun fetchData(): ApiImplementation
}