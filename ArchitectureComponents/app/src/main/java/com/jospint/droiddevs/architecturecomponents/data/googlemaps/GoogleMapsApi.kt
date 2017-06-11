package com.jospint.droiddevs.architecturecomponents.data.googlemaps

import com.jospint.droiddevs.architecturecomponents.data.googlemaps.model.GeocodeResponse
import com.jospint.droiddevs.architecturecomponents.data.googlemaps.model.PlaceResponse
import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleMapsApi {

    companion object {
        const val BASE_URL: String = "https://maps.googleapis.com/maps/api/";
    }

    @GET("geocode/json")
    fun getGeocode(
            @Query("latlng") latlng: String
    ): Flowable<GeocodeResponse>

    @GET("place/textsearch/json")
    fun getPlace(
            @Query("query") query: String,
            @Query("type") type: String,
            @Query("key") key: String
    ): Flowable<PlaceResponse>

}