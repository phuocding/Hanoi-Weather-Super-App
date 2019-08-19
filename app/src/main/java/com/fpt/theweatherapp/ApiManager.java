package com.fpt.theweatherapp;

import com.fpt.theweatherapp.model.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiManager {

    public static String API_URL = "http://dataservice.accuweather.com";

    @GET("forecasts/v1/hourly/12hour/353412?apikey=C8BQmAqYEvP0NOGjAkW5sZptqCuljNm7&language=vi-vn&metric=true")
    Call<List<Weather>> getHour();
}