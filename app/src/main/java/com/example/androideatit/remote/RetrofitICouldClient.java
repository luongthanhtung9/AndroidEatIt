package com.example.androideatit.remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitICouldClient {
    public static Retrofit retrofit = null;
    public static Retrofit getIntance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://us-central1-eatit-1d424.cloudfunctions.net/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
        }
        return retrofit;
    }
}
