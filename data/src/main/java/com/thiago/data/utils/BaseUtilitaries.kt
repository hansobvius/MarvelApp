package com.thiago.data.utils

import android.net.ConnectivityManager
import com.thiago.data.utils.DataConstants.CONNECTIVITY_STATUS_SUCCESS
import com.thiago.data.utils.DataConstants.PRIVATE_KEY
import com.thiago.data.utils.DataConstants.PUBLIC_KEY
import java.io.IOException
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

abstract class BaseUtilitaries: BaseUtilsImplementation {

    override fun getConnectionStatus(): Boolean = getNetworkStatus()

    override fun getHashCode(): String = getHashCodeGenerated()

    override fun getTimestamp(): Int = getTimestampGenerated()

    private fun getNetworkStatus(): Boolean{
        val connectivity = ConnectivityManager.EXTRA_NO_CONNECTIVITY
        return if(connectivity.equals(CONNECTIVITY_STATUS_SUCCESS)) true else false
    }

    private fun getTimestampGenerated(): Int {
        val timestamp = Timestamp(System.currentTimeMillis()/1000)
        return timestamp.time.toInt()
    }

    private fun getHashCodeGenerated(): String{
        val value: String = getTimestamp().toString().plus(PRIVATE_KEY).plus(PUBLIC_KEY)
        val md5Result: String
        try{
            val md5 = MessageDigest.getInstance("MD5")
            md5.update(value.toByteArray(), 0, value.length)
            var result = BigInteger(1, md5.digest()).toString(16)
            while(result.length < 32){
                result = "0" + value
            }
            md5Result = result
        }catch(e: IOException){
            throw IOException("No Alghoritm available")
        }
        return md5Result
    }
}