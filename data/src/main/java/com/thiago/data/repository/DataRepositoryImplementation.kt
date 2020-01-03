package com.thiago.data.repository

import androidx.lifecycle.LiveData

interface DataRepositoryImplementation<T> {

    fun fetchData()

    fun getData(): LiveData<List<T>>
}