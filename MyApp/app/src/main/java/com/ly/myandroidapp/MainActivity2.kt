package com.ly.myandroidapp

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.ly.myandroidapp.databinding.ActivityMain2Binding
import com.ly.myandroidapp.model.MyViewModel
import com.ly.myandroidapp.model.Parent

class MainActivity2 : AppCompatActivity() {
    val p = Parent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main2)
        val model: MyViewModel by viewModels()
        val binding = DataBindingUtil.setContentView<ActivityMain2Binding>(this,R.layout.activity_main2)
//        binding.p = p
        binding.model = model

        val ob = Observer<String> {
            Log.d("livedata:",it)
        }
        model.name.observe(this,ob)

    }
}