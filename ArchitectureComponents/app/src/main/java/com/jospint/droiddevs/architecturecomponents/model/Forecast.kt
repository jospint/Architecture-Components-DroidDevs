package com.jospint.droiddevs.architecturecomponents.model

data class Forecast(
        val timestamp: Double,
        val iconId: String,
        val description: String,
        val temperature: Double,
        val windSpeed: Double,
        val prediction: String)