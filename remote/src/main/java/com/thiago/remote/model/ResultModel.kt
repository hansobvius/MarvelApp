package com.thiago.remote.model

import com.google.gson.annotations.SerializedName
import com.thiago.remote.model.submodel.HeroesRemoteModel

class ResultModel(@SerializedName("results") val listResult: List<HeroesRemoteModel>)