package com.express.android.bersyteweatherapp.viewmodel

import androidx.lifecycle.*
import com.express.android.bersyteweatherapp.model.Weather
import com.express.android.bersyteweatherapp.repository.WeatherRepository
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel
@Inject
constructor(private val repository: WeatherRepository):ViewModel() {

    val response: MutableLiveData<Weather> = MutableLiveData<Weather>()
    //val weatherResponse: LiveData<Weather> get() = response

//    init {
//        getWeather(cityName = "Miami")
//    }

    fun getWeather(cityName: String) = viewModelScope.launch {
        repository.getWeather(cityName).let { _response ->

            if (_response.isSuccessful) {
                response.postValue(_response.body())
            } else {
                //Log.d("tag", "getWeather Error: ${response.code()}")
            }
        }
    }

//    class WeatherViewModelFactory(val weatherRepository: WeatherRepository) : ViewModelProvider.Factory {
//        override fun <T : ViewModel> create(modelClass: Class<T>): T {
//            return WeatherViewModel( weatherRepository) as T
//        }
//    }
}