package com.express.android.bersyteweatherapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.express.android.bersyteweatherapp.databinding.WeatherFragmentBinding
import com.express.android.bersyteweatherapp.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private var _binding: WeatherFragmentBinding? = null
    private val binding: WeatherFragmentBinding get() = _binding!!

    lateinit var cityName: String

    private val args by navArgs<WeatherFragmentArgs>()

    private val weatherViewModel: WeatherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = WeatherFragmentBinding.inflate(inflater, container, false)

        cityName = args.cityName

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        weatherViewModel.getWeather(cityName)

        weatherViewModel.response.observe(viewLifecycleOwner) { weather ->

            binding.apply {
                tvCityName.text = cityName
                tvDescription.text = weather.description
                tvTemperature.text = weather.temperature
                tvWind.text = weather.wind

                val forecast = weather.forecast
                tvForecast1.text = "${forecast[0].temperature}/ ${forecast[0].wind}"
                tvForecast2.text = "${forecast[1].temperature}/ ${forecast[1].wind}"
                tvForecast3.text = "${forecast[2].temperature}/ ${forecast[2].wind}"
            }
        }
    }
}

