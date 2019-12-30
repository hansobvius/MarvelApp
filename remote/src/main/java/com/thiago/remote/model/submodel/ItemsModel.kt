package com.thiago.remote.model.submodel

import com.google.gson.annotations.SerializedName

class ItemsModel(@SerializedName("resourceURI") val resourceUri: String,
                 @SerializedName("name") val name: String,
                 @SerializedName("role") val role: String? = "")