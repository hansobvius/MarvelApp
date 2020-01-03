package com.thiago.marvelapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.stetho.Stetho
import com.thiago.data.DataProject
import com.thiago.marvelapp.BuildConfig
import com.thiago.marvelapp.R
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val dataProject: DataProject by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart(){
        super.onStart()
        if(BuildConfig.DEBUG)Stetho.initializeWithDefaults(this);
    }

    override fun onResume(){
        super.onResume()
        dataProject.fecthProject()
    }
}
