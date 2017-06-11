package com.jospint.droiddevs.architecturecomponents.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.os.AsyncTask
import com.jospint.droiddevs.architecturecomponents.data.darksky.DarkSkyRepository
import com.jospint.droiddevs.architecturecomponents.db.AppDatabase
import com.jospint.droiddevs.architecturecomponents.model.Forecast
import com.jospint.droiddevs.architecturecomponents.model.Place
import com.jospint.droiddevs.architecturecomponents.util.Resource
import javax.inject.Inject


class ForecastViewModel
@Inject
constructor(private val darkSkyRepository: DarkSkyRepository, private val database: AppDatabase) : ViewModel() {

    private var currentLatitude: Double? = null
    private var currentLongitude: Double? = null
    private var forecastData: LiveData<Resource<Forecast>>? = null

    fun getForecast(latitude: Double, longitude: Double): LiveData<Resource<Forecast>> {
        if (forecastData == null || (latitude != currentLatitude && longitude != currentLongitude)) {
            currentLatitude = latitude
            currentLongitude = longitude
            forecastData = darkSkyRepository.getForecast(latitude, longitude)
        }
        return forecastData!!;
    }

    fun saveForecast(place: Place, forecast: Forecast) {
        place.forecast = forecast
        AsyncTask.execute({ database.ForecastDao().insertPlace(place) })

    }

}
