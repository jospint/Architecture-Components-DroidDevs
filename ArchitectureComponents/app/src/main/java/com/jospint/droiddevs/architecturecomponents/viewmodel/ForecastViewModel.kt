package com.jospint.droiddevs.architecturecomponents.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.jospint.droiddevs.architecturecomponents.data.darksky.DarkSkyRepository
import com.jospint.droiddevs.architecturecomponents.data.darksky.model.Forecast
import com.jospint.droiddevs.architecturecomponents.util.Resource
import javax.inject.Inject


class ForecastViewModel
@Inject
constructor(private val darkSkyRepository: DarkSkyRepository) : ViewModel() {

    private var currentLatitude: Double? = null
    private var currentLongitude: Double? = null
    private var forecast: MutableLiveData<Resource<Forecast>>? = null

    fun getForecast(latitude: Double, longitude: Double): MutableLiveData<Resource<Forecast>> {
        if (forecast == null || (latitude != currentLatitude && longitude != currentLongitude)) {
            currentLatitude = latitude
            currentLongitude = longitude
            forecast = darkSkyRepository.getForecast(latitude, longitude)
        }
        return forecast!!;
    }

}
