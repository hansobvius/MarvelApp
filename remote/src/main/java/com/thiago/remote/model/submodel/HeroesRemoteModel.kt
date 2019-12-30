package com.thiago.remote.model.submodel

import com.google.gson.annotations.SerializedName

class HeroesRemoteModel(
        @SerializedName("id") val id:Int,
        @SerializedName("name") val name: String,
        @SerializedName("description") val description: String,
        @SerializedName("thumbnail") val imageResource: ImageSourceModel,
        @SerializedName("comics") val comics: ComicsModel
)