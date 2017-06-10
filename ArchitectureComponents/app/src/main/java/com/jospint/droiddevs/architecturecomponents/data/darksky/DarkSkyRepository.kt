package com.jospint.droiddevs.architecturecomponents.data.darksky

import android.arch.lifecycle.MutableLiveData
import com.jospint.droiddevs.architecturecomponents.BuildConfig
import com.jospint.droiddevs.architecturecomponents.data.darksky.model.Forecast
import com.jospint.droiddevs.architecturecomponents.util.Resource
import javax.inject.Inject
import javax.inject.Singleton
import com.jospint.droiddevs.architecturecomponents.util.extension.enqueueToResource

@Singleton
class DarkSkyRepository
@Inject
constructor(private val darkSkyApi: DarkSkyApi) {

    fun getForecast(latitude: Double, longitude: Double): MutableLiveData<Resource<Forecast>> =
            darkSkyApi.getForecast(BuildConfig.DARK_SKY_API_KEY, latitude, longitude, "ca").enqueueToResource();


    fun getTimeMachineForecast(latitude: Double, longitude: Double, time: Int): MutableLiveData<Resource<Forecast>> =
            darkSkyApi.getTimeMachineForecast(BuildConfig.DARK_SKY_API_KEY, latitude, longitude, time, "ca").enqueueToResource();

}