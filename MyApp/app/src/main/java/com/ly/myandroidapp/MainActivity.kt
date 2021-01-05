package com.ly.myandroidapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ly.myandroidapp.networking.ApiService
import com.ly.myandroidapp.networking.AppClient


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppClient.createService(ApiService::class.java)
    }


}