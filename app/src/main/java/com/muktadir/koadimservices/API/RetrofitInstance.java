package com.muktadir.koadimservices.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit;
    //Home data url
    private static final String BASE_URL_HOME = "https://5d1dae5d3374890014f005d1.mockapi.io/";
    //Events data url
    private static final String BASE_URL_EVENT = "https://5d1dae5d3374890014f005d1.mockapi.io/";
    public static Retrofit getRetrofitInstance_Home() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL_HOME)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static Retrofit getRetrofitInstance_Events() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL_EVENT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
