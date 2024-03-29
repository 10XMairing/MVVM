package com.example.mvvmsample.retrofit;

import com.example.mvvmsample.data.api.ApiService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String TAG = "RetrofitClient";

    static Retrofit.Builder builder;
    private static Retrofit retrofit=null;

    public static Retrofit getRetrofit(){

        if (retrofit==null) {

            builder = new Retrofit.Builder().baseUrl(ApiService.BASE_URL).addConverterFactory(GsonConverterFactory.create());

            retrofit = builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();

        }
        return retrofit;

    }


}
