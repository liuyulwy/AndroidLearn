package com.ly.myandroidapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.ly.myandroidapp.databinding.ActivityMainBinding
import com.ly.myandroidapp.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var user = User()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        val binding = setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.user = user

        button1.setOnClickListener {
            user.name.set("test")
        }

    }


}