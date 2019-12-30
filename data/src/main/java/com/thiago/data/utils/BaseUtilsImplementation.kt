package com.thiago.data.utils

interface BaseUtilsImplementation {

    fun getConnectionStatus(): Boolean

    fun getHashCode(): String

    fun getTimestamp(): Int
}