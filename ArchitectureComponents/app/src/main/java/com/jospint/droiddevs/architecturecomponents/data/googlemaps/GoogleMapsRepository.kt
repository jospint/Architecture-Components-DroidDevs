package com.jospint.droiddevs.architecturecomponents.data.googlemaps

import android.arch.lifecycle.MutableLiveData
import com.jospint.droiddevs.architecturecomponents.BuildConfig
import com.jospint.droiddevs.architecturecomponents.data.googlemaps.model.GeocodeResponse
import com.jospint.droiddevs.architecturecomponents.data.googlemaps.model.PlaceResponse
import com.jospint.droiddevs.architecturecomponents.util.Resource
import com.jospint.droiddevs.architecturecomponents.util.extension.enqueueToResource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GoogleMapsRepository
@Inject
constructor(private val googleMapsApi: GoogleMapsApi) {

    fun getGeocode(latitude: Double, longitude: Double): MutableLiveData<Resource<GeocodeResponse>> =
            googleMapsApi.getGeocode(latitude.toString().plus(",").plus(longitude.toString())).enqueueToResource()


    fun getLocality(query: String): MutableLiveData<Resource<PlaceResponse>> =
            googleMapsApi.getPlace(query, "locality", BuildConfig.GOOGLE_PLACES_API_KEY).enqueueToResource()


}