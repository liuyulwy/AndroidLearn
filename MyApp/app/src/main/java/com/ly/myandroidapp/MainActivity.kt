package com.ly.myandroidapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ly.myandroidapp.networking.AppClient
import okhttp3.ResponseBody
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppClient.getInstance().apiServer.chapters.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(object : Observer<ResponseBody?> {
                    override fun onCompleted() {}
                    override fun onError(e: Throwable) {}
                    override fun onNext(responseBody: ResponseBody?) {}
                })

    }


}