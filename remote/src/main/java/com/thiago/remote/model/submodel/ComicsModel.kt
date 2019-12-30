package com.thiago.remote.model.submodel

import com.google.gson.annotations.SerializedName

class ComicsModel(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("variantDescription") val variantDescripetion: String,
    @SerializedName("description") val description: String,
    @SerializedName("modified") val modified: String,
    @SerializedName("thumbnail") val thumbnail: ImageSourceModel,
    @SerializedName("images") val images: ImageSourceModel,
    @SerializedName("creators") val creators: CreatorsModel,
    @SerializedName("characters") val characters: CharactersModel,
    @SerializedName("stories") val stories: StoriesModel
)