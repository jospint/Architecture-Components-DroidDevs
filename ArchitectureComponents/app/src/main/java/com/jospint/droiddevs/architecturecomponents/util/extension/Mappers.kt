package com.jospint.droiddevs.architecturecomponents.util.extension

import com.jospint.droiddevs.architecturecomponents.data.darksky.model.ForecastData
import com.jospint.droiddevs.architecturecomponents.data.googlemaps.model.PlaceResult
import com.jospint.droiddevs.architecturecomponents.model.Forecast
import com.jospint.droiddevs.architecturecomponents.model.Place

fun PlaceResult.toPlace(): Place =
        Place(
                id = this.id!!,
                name = this.name!!,
                latitude = this.geometry?.location?.lat!!,
                longitude = this.geometry.location.lng!!)

fun ForecastData.toForecast(): Forecast =
        Forecast(
                timestamp = this.currently?.time?.toDouble()!!,
                iconId = this.currently.icon!!,
                description = this.currently.summary!!,
                temperature = this.currently.temperature!!,
                windSpeed = this.currently.windSpeed!!,
                prediction = this.daily?.summary!!)

