package com.ly.myandroidapp.networking;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {

    @GET("wxarticle/chapters/json")
    Observable<ResponseBody> getChapters();

}
