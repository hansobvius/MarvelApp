package com.thiago.data.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.thiago.cache.DatabaseRepository
import com.thiago.data.mapper.ModelMapper
import com.thiago.data.model.HeroesDataModel
import com.thiago.data.utils.DataConstants.LIMIT
import com.thiago.data.utils.BaseUtilitaries
import com.thiago.data.utils.DataConstants.API_KEY
import com.thiago.remote.RemoteProject
import com.thiago.remote.endpoint.ApiImplementation
import kotlinx.coroutines.*
import java.io.IOException

class DataRepository(
    val remoteProject: RemoteProject,
    val databaseRepository: DatabaseRepository): BaseUtilitaries(), DataRepositoryImplementation {

    private var codeHashUser: String
    private var timeStamp: Int
    private var scope: CoroutineScope
    private val job = SupervisorJob()
    private val dataList = databaseRepository.getDatabase()
    private val mapper: ModelMapper = ModelMapper()

    init{
        codeHashUser = getHashCode()
        timeStamp = getTimestamp()
        scope = CoroutineScope(job + Dispatchers.Main)
    }

    override fun fetchData() {
        if(dataList.value == null && getConnectionStatus()){
            scope.launch {
                insert()
            }
        }
    }

    override fun getData(): LiveData<List<HeroesDataModel>> {
        return Transformations.map(dataList){
            dataList.value!!.map {
                mapper.cacheToData(it)
            }
        }
    }

    suspend fun insert(){
        withContext(Dispatchers.IO){
            try{
                val request = remoteProject
                        .fetchData()
                        .SERVICE
                        .getSource(LIMIT, API_KEY, timeStamp, codeHashUser).await()
                request.result.listResult.map {
                    databaseRepository.insertDatabase(mapper.remoteToCache(it))
                }
            }catch (e: IOException){
                Log.i("request", "ERROR")
            }
        }
    }
}