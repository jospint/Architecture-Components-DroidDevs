package com.jospint.droiddevs.architecturecomponents.data.darksky

import android.arch.lifecycle.MutableLiveData
import com.jospint.droiddevs.architecturecomponents.BuildConfig
import com.jospint.droiddevs.architecturecomponents.data.darksky.model.ForecastData
import com.jospint.droiddevs.architecturecomponents.util.Resource
import javax.inject.Inject
import javax.inject.Singleton
import com.jospint.droiddevs.architecturecomponents.util.extension.enqueueToResource
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import com.jospint.droiddevs.architecturecomponents.model.Forecast
import com.jospint.droiddevs.architecturecomponents.util.ResourceStatus
import com.jospint.droiddevs.architecturecomponents.util.extension.toForecast

@Singleton
class DarkSkyRepository
@Inject
constructor(private val darkSkyApi: DarkSkyApi) {

    companion object {
        private const val UNITS_CA = "ca"
    }

    fun getForecast(latitude: Double, longitude: Double): LiveData<Resource<Forecast>> {
        val remoteData = darkSkyApi.getForecast(BuildConfig.DARK_SKY_API_KEY, latitude, longitude, UNITS_CA).enqueueToResource();
        return Transformations.switchMap(remoteData) {
            val forecastLiveData = MutableLiveData<Resource<Forecast>>()
            when (remoteData.value?.resourceStatus) {
                ResourceStatus.SUCCESS -> forecastLiveData.value = Resource.success(remoteData.value?.data?.toForecast()!!)
                ResourceStatus.ERROR -> forecastLiveData.value = Resource.error(remoteData.value?.message!!)
                ResourceStatus.LOADING -> forecastLiveData.value = Resource.loading(remoteData.value?.message)
            }
            return@switchMap forecastLiveData
        }
    }

    fun getTimeMachineForecast(latitude: Double, longitude: Double, time: Int): MutableLiveData<Resource<ForecastData>> =
            darkSkyApi.getTimeMachineForecast(BuildConfig.DARK_SKY_API_KEY, latitude, longitude, time, UNITS_CA).enqueueToResource();

}