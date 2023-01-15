package com.express.android.bersyteweatherapp.repository

import com.express.android.bersyteweatherapp.api.ApiService
import javax.inject.Inject

class WeatherRepository
@Inject
constructor(private val apiService: ApiService) {

    suspend fun getWeather(cityName: String) = apiService.getWeather(cityName)
}