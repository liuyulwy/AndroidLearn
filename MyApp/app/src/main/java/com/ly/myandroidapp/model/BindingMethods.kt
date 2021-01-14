package com.ly.myandroidapp.model

import android.widget.TextView
import androidx.databinding.BindingAdapter

object BindingAdapters{

    @BindingAdapter("app:bindText")
    @JvmStatic fun bindText(view: TextView, text: String){
        view.text = text
    }

}