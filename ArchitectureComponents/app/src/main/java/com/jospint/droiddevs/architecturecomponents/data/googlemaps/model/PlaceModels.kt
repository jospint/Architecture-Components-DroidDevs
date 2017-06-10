package com.jospint.droiddevs.architecturecomponents.data.googlemaps.model

import com.squareup.moshi.Json
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@PaperParcel
data class PlaceResponse(
        @Json(name = "html_attributions") val htmlAttributions: List<String>?,
        val results: List<PlaceResult>?,
        val status: String?): PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelPlaceResponse.CREATOR
    }
}

@PaperParcel
data class PlaceResult(
        @Json(name = "formatted_address") val formattedAddress: String?,
        val geometry: Geometry?,
        val icon: String?,
        val id: String?,
        val name: String?,
        val photos: List<Photo>?,
        @Json(name = "place_id") val placeId: String?,
        val reference: String?,
        val types: List<String>?): PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelPlaceResult.CREATOR
    }
}

@PaperParcel
data class Photo(
        val height: Int?,
        val width: Int?,
        @Json(name = "html_attributions") val htmlAttributions: List<String>?,
        @Json(name = "photo_reference") val photoReference: String?): PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelPhoto.CREATOR
    }
}