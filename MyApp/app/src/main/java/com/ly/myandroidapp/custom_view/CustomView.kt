package com.ly.myandroidapp.custom_view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.ly.myandroidapp.LOG
import com.ly.myandroidapp.R

class CustomView: View {

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        val typeArr = context?.obtainStyledAttributes(attrs, R.styleable.custom_attr_test)
        val s = typeArr?.getString(R.styleable.custom_attr_test_testText)
        val i = typeArr?.getInteger(R.styleable.custom_attr_test_testInteger, 0)
        Log.d(LOG, "$s=====$i")
        typeArr?.recycle()
    }
}


