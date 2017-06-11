package com.jospint.droiddevs.architecturecomponents.data.darksky

import com.jospint.droiddevs.architecturecomponents.data.darksky.model.ForecastData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DarkSkyApi {

    companion object {
        const val BASE_URL: String = "https://api.darksky.net/forecast/";
    }

    @GET("{key}/{latitude},{longitude}")
    fun getForecast(
            @Path("key") key: String,
            @Path("latitude") latitude: Double,
            @Path("longitude") longitude: Double,
            @Query("units") units: String?
    ): Call<ForecastData>

    @GET("{key}/{latitude},{longitude},{time}")
    fun getTimeMachineForecast(
            @Path("key") key: String,
            @Path("latitude") latitude: Double,
            @Path("longitude") longitude: Double,
            @Path("time") time: Int,
            @Query("units") units: String?
    ): Call<ForecastData>

}