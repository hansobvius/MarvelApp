package com.thiago.marvelapp.mapper

interface MapperImplementation<D, A> {

    fun dataToPresentation(data: D): A
}