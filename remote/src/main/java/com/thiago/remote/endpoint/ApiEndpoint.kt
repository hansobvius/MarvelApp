package com.thiago.remote.endpoint

import com.thiago.remote.model.DataModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndpoint {

    @GET("characters")
    fun getSource(@Query("limit")limit: Int,
                  @Query("apikey")key: String,
                  @Query("ts")ts: Int,
                  @Query("hash")hash: String): Deferred<DataModel>
}