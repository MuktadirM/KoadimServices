package com.muktadir.koadimservices.API;

import com.muktadir.koadimservices.APIDataModel.EventData;
import com.muktadir.koadimservices.APIDataModel.HomeData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API_Interface {
    @GET("api/v1/home")
    Call<List<HomeData>> HomeContent();

    @GET("api/v1/events")
    Call<List<EventData>>EventContent();

}
