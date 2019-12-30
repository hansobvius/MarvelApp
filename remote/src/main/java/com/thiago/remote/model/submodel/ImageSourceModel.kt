package com.thiago.remote.model.submodel

import com.google.gson.annotations.SerializedName

class ImageSourceModel(
        @SerializedName("path") val urlPath: String,
        @SerializedName("extension") val extension: String)