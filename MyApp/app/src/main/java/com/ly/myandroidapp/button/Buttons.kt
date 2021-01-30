package com.ly.myandroidapp.button

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ly.myandroidapp.R
import kotlinx.android.synthetic.main.activity_button.*

class Buttons : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        system_id.setOnClickListener {

        }
    }
}