package com.jospint.droiddevs.architecturecomponents.data.googlemaps.model

import com.squareup.moshi.Json
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@PaperParcel
data class Geometry(
        val location: Location?,
        @Json(name = "location_type") val locationType: String?,
        val viewport: Viewport?,
        val bounds: Bounds?) : PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelGeometry.CREATOR
    }
}

@PaperParcel
data class Viewport(
        val northeast: Location?,
        val southwest: Location?) : PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelViewport.CREATOR
    }
}

@PaperParcel
data class Bounds (
        val northeast: Location?,
        val southwest: Location?) : PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelBounds.CREATOR
    }
}

@PaperParcel
data class Location(
        val lat: Double?,
        val lng: Double?) : PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelLocation.CREATOR
    }
}
