package com.jospint.droiddevs.architecturecomponents.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Place(
        @PrimaryKey val id: String,
        val name: String,
        val latitude: Double,
        val longitude: Double,
        @Embedded var forecast: Forecast? = null){



}