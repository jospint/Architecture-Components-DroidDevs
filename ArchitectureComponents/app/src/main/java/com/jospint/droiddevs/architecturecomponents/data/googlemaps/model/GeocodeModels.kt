package com.jospint.droiddevs.architecturecomponents.data.googlemaps.model

import com.squareup.moshi.Json
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

@PaperParcel
data class GeocodeResponse(
        val results: List<GeocodeResult>?,
        val status: String?) : PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelGeocodeResponse.CREATOR
    }
}

@PaperParcel
data class GeocodeResult(
        @Json(name = "address_components") val addressComponents: List<AddressComponent>?,
        @Json(name = "formatted_address") val formattedAddress: String?,
        val geometry: Geometry?,
        @Json(name = "place_id") val placeId: String?,
        val types: List<String>?) : PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelGeocodeResult.CREATOR
    }
}

@PaperParcel
data class AddressComponent(
        @Json(name = "long_name") val longName: String?,
        @Json(name = "short_name") val shortName: String?,
        val types: List<String>?) : PaperParcelable {
    companion object {
        @JvmField val CREATOR = PaperParcelAddressComponent.CREATOR
    }
}