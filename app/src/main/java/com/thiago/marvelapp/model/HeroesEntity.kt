package com.thiago.marvelapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class HeroesEntity(
        val id: Int,
        val name: String,
        val description: String,
        val image: String): Parcelable