package com.thiago.remote.model.submodel

import com.google.gson.annotations.SerializedName

class CreatorsModel(@SerializedName("available") val available: Int,
                    @SerializedName("collectionUri") val collectionUri: String,
                    @SerializedName("items") val items: ItemsModel
)