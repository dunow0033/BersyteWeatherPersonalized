package com.express.android.bersyteweatherapp.api

import com.express.android.bersyteweatherapp.model.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("weather/{cityName}")
    suspend fun getWeather(
        @Path("cityName") cityName: String
    ): Response<Weather>
}