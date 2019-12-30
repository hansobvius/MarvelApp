package com.thiago.data

import androidx.lifecycle.LiveData

interface DataImplementation<D> {

    fun fecthProject()

    fun getProject(): LiveData<List<D>>
}