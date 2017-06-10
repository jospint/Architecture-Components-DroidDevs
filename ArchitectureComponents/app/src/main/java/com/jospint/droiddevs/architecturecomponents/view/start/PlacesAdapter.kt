package com.jospint.droiddevs.architecturecomponents.view.start

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jospint.droiddevs.architecturecomponents.R
import com.jospint.droiddevs.architecturecomponents.data.googlemaps.model.PlaceResult
import com.jospint.droiddevs.architecturecomponents.util.extension.singleClick
import kotlinx.android.synthetic.main.view_locality.view.*
import kotlin.properties.Delegates


class PlacesAdapter : RecyclerView.Adapter<PlacesAdapter.LocalityVH>() {

    var listener: (PlaceResult) -> Unit = {}
    var places: List<PlaceResult> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

    override fun onBindViewHolder(holder: LocalityVH, position: Int) {
        val place = places[position]
        holder.itemView.apply {
            singleClick { listener(place) }
            locality_name.text = place.name
            locality_address.text = place.formattedAddress
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalityVH
            = LocalityVH(LayoutInflater.from(parent.context).inflate(R.layout.view_locality, parent, false))

    override fun getItemCount(): Int = places.size

    class LocalityVH(itemView: View) : RecyclerView.ViewHolder(itemView)

}