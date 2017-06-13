package com.jospint.droiddevs.architecturecomponents.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.jospint.droiddevs.architecturecomponents.data.googlemaps.GoogleMapsRepository
import com.jospint.droiddevs.architecturecomponents.data.googlemaps.model.PlaceResponse
import com.jospint.droiddevs.architecturecomponents.util.Resource
import javax.inject.Inject

class PlaceViewModel
@Inject
constructor(private val googleMapsRepository: GoogleMapsRepository) : ViewModel() {

    private var currentSearch: String? = null;
    private var places: MutableLiveData<Resource<PlaceResponse>>? = null

    fun getPlaces(place: String): MutableLiveData<Resource<PlaceResponse>> {
        if (places == null || place != currentSearch) {
            currentSearch = place;
            places = googleMapsRepository.getLocality(place);
        }
        return places!!;
    }

}