package com.thiago.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.thiago.cache.DatabaseRepository
import com.thiago.cache.model.HeroesCacheModel
import com.thiago.data.mapper.ModelMapper
import com.thiago.data.model.HeroesDataModel
import com.thiago.data.utils.BaseUtilitaries
import com.thiago.data.utils.DataConstants.API_KEY
import com.thiago.data.utils.DataConstants.LIMIT
import com.thiago.remote.RemoteProject
import kotlinx.coroutines.*
import java.io.IOException

class DataRepository(
    private val remoteProject: RemoteProject,
    private val databaseRepository: DatabaseRepository,
    private val modelMapper: ModelMapper): BaseUtilitaries(), DataRepositoryImplementation<HeroesDataModel> {

    private var codeHashUser: String
    private var timeStamp: Int
    private var dataList: LiveData<List<HeroesCacheModel>>
    private var scope: CoroutineScope
    private val job = SupervisorJob()

    init{
        codeHashUser = getHashCode()
        timeStamp = getTimestamp()
        dataList = databaseRepository.getDatabase()
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
                modelMapper.cacheToData(it)
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
                    databaseRepository.insertDatabase(modelMapper.remoteToCache(it))
                }
            }catch (e: IOException){
                Log.i("request", "ERROR")
            }
        }
    }
}