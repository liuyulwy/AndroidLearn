package com.ly.myandroidapp.networking;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import  okhttp3.logging.HttpLoggingInterceptor.Logger;

public class AppClient {
    private static final int DEFAULT_TIME_OUT = 15;
    private static String baseUrl = "https://wanandroid.com/";
    private static Retrofit mRetrofit;
    private static AppClient mAppClient;

    private AppClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new Logger() {
            @Override
            public void log(@NotNull String s) {
                Log.d("AppClient", s);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .callTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public static AppClient getInstance(){
        if (mAppClient == null){
            mAppClient = new AppClient();
        }
        return mAppClient;
    }

    public static <S> S createService(Class<S> serviceClass) {
        return mRetrofit.create(serviceClass);
    }

    public ApiService getApiServer() {
        return createService(ApiService.class);
    }
}
