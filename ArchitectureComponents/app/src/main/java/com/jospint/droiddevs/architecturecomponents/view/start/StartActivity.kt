package com.jospint.droiddevs.architecturecomponents.view.start

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.widget.Toast
import com.jakewharton.rxbinding2.widget.RxTextView
import com.jospint.droiddevs.architecturecomponents.R
import com.jospint.droiddevs.architecturecomponents.data.googlemaps.model.PlaceResponse
import com.jospint.droiddevs.architecturecomponents.util.Resource
import com.jospint.droiddevs.architecturecomponents.util.ResourceStatus
import com.jospint.droiddevs.architecturecomponents.view.BaseActivity
import com.jospint.droiddevs.architecturecomponents.view.forecast.ForecastActivity
import com.jospint.droiddevs.architecturecomponents.viewmodel.PlaceViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_start.*
import org.jetbrains.anko.act
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class StartActivity : BaseActivity() {

    companion object {
        private const val LOOKUP_DEBOUNCE_MILLIS: Long = 500
        private const val LOOKUP_THRESHOLD = 2
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var adapter: PlacesAdapter

    lateinit var placeViewModel: PlaceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        placeViewModel = ViewModelProviders.of(this, viewModelFactory).get(PlaceViewModel::class.java)
        setupUI()
    }

    private fun setupUI() {
        setupResultsList()
        setupInput()
    }

    private fun setupResultsList() {
        start_results.adapter = adapter
        start_results.addItemDecoration(DividerItemDecoration(act, DividerItemDecoration.VERTICAL))
        adapter.listener = { it -> startActivity(ForecastActivity.buildIntent(act, it)) }
    }

    private fun setupInput() {
        RxTextView.afterTextChangeEvents(start_input)
                .skip(1).debounce(LOOKUP_DEBOUNCE_MILLIS, TimeUnit.MILLISECONDS)
                .filter { input -> input.editable().toString().length > LOOKUP_THRESHOLD }
                .observeOn(AndroidSchedulers.mainThread()).subscribe { input ->
            placeViewModel.getPlaces(input.editable().toString())
                    .observe(this@StartActivity, Observer<Resource<PlaceResponse>> { resource ->
                        when (resource!!.resourceStatus) {
                            ResourceStatus.SUCCESS -> adapter.places = resource.data?.results!!
                            ResourceStatus.ERROR -> Toast.makeText(this@StartActivity, "Can't get places!!! :(", Toast.LENGTH_SHORT).show();
                            ResourceStatus.LOADING -> Toast.makeText(this@StartActivity, "Loading!", Toast.LENGTH_SHORT).show();
                        }
                    })
        }
    }

}