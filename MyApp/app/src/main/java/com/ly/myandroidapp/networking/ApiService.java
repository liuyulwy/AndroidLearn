package com.ly.myandroidapp.networking;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;


public interface ApiService {

    @GET("wxarticle/chapters/json")
    Observable<ResponseBody> getChapters();

}
