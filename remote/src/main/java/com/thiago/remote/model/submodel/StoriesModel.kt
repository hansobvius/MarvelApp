package com.thiago.remote.model.submodel

import com.google.gson.annotations.SerializedName
import com.thiago.remote.model.submodel.ItemsModel

class StoriesModel(
    @SerializedName("available") val available: Int,
    @SerializedName("collectionUri") val collectionUri: String,
    @SerializedName("items") val items: ItemsModel
)