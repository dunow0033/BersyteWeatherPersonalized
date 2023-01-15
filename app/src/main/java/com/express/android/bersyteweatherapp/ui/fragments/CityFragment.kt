package com.express.android.bersyteweatherapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.express.android.bersyteweatherapp.R
import com.express.android.bersyteweatherapp.databinding.FragmentCityBinding
import com.express.android.bersyteweatherapp.repository.WeatherRepository
import com.express.android.bersyteweatherapp.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityFragment : Fragment() {

    private var _binding: FragmentCityBinding? = null
    private val binding get() = _binding!!

    //private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCityBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        weatherViewModel = ViewModelProvider(
//            this,
//            WeatherViewModel.WeatherViewModelFactory(WeatherRepository(WeatherManager()))
//        ).get(WeatherViewModel::class.java)

        //weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        binding.nextButton.setOnClickListener {
            val cityName = binding.etCity.text.toString()
            val bundle = bundleOf("cityName" to cityName)
            findNavController().navigate(R.id.action_cityFragment_to_weatherFragment, bundle)

        }
    }
}