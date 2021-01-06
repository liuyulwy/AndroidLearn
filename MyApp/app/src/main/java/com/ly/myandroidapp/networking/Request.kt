package com.ly.myandroidapp.networking

import okhttp3.ResponseBody
import retrofit2.http.GET

public interface Request {
    @GET("wxarticle/chapters/json")
    suspend fun getChapters(): ResponseBody
}