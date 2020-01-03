package com.thiago.remote

import com.thiago.remote.endpoint.ApiImplementation

class RemoteProject(
    private val apiImplementation: ApiImplementation): RemoteImplementation {
    
    override fun fetchData(): ApiImplementation {
        return this.apiImplementation
    }
}
