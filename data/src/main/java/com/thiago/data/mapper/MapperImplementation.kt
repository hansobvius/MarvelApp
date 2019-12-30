package com.thiago.data.mapper

interface MapperImplementation<in R, C, D> {

    fun remoteToCache(remote: R): C

    fun cacheToData(cache: C): D
}