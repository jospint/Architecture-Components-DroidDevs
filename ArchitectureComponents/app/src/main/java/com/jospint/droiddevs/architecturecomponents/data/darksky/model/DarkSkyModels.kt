package com.jospint.droiddevs.architecturecomponents.data.darksky.model

import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@PaperParcel
data class Forecast(
        val latitude: Double,
        val longitude: Double,
        val timezone: String?,
        val offset: Int?,
        val currently: DataPoint?,
        val minutely: DataBlock?,
        val hourly: DataBlock?,
        val daily: DataBlock?,
        val flags: Flags?) : PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelForecast.CREATOR
    }
}

@PaperParcel
data class DataBlock(
        val summary: String?,
        val icon: String?,
        val data: List<DataPoint>?): PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelDataBlock.CREATOR
    }
}

@PaperParcel
data class DataPoint(
        val time: Int,
        val summary: String?,
        val icon: String?,
        val sunriseTime: Int?,
        val sunsetTime: Int?,
        val moonPhase: Double?,
        val precipAccumulation: Double?,
        val precipIntensity: Double?,
        val precipIntensityMax: Double?,
        val precipIntensityMaxTime: Int?,
        val precipProbability: Double?,
        val precipType: String?,
        val temperature: Double?,
        val temperatureMin: Double?,
        val temperatureMinTime: Int?,
        val temperatureMax: Double?,
        val temperatureMaxTime: Int?,
        val apparentTemperature: Double?,
        val apparentTemperatureMin: Double?,
        val apparentTemperatureMinTime: Int?,
        val apparentTemperatureMax: Double?,
        val apparentTemperatureMaxTime: Int?,
        val dewPoint: Double?,
        val humidity: Double?,
        val windSpeed: Double?,
        val windBearing: Int?,
        val visibility: Double?,
        val cloudCover: Double?,
        val pressure: Double?,
        val ozone: Double?,
        val nearestStormBearing: Int?,
        val nearestStormDistance: Double?): PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelDataPoint.CREATOR
    }
}

@PaperParcel
data class Flags(
        val sources: List<String>?,
        val lampStations: List<String>?,
        val isdStations: List<String>?,
        val madisStations: List<String>?,
        val sunits: String?): PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelFlags.CREATOR
    }
}