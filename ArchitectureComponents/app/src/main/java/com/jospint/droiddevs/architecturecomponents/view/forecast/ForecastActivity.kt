package com.jospint.droiddevs.architecturecomponents.view.forecast

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.widget.Toast
import com.jospint.droiddevs.architecturecomponents.R
import com.jospint.droiddevs.architecturecomponents.data.googlemaps.model.PlaceResult
import com.jospint.droiddevs.architecturecomponents.db.AppDatabase
import com.jospint.droiddevs.architecturecomponents.model.Forecast
import com.jospint.droiddevs.architecturecomponents.util.Resource
import com.jospint.droiddevs.architecturecomponents.util.ResourceStatus
import com.jospint.droiddevs.architecturecomponents.util.extension.toPlace
import com.jospint.droiddevs.architecturecomponents.view.BaseActivity
import com.jospint.droiddevs.architecturecomponents.viewmodel.ForecastViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_forecast.*
import org.jetbrains.anko.act
import javax.inject.Inject

class ForecastActivity : BaseActivity() {

    companion object {
        private const val EXTRA_PLACE: String = "place";

        fun buildIntent(context: Context, place: PlaceResult): Intent {
            val intent = Intent(context, ForecastActivity::class.java)
            intent.putExtra(EXTRA_PLACE, place);
            return intent;
        }
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var forecastViewModel: ForecastViewModel

    lateinit var placeResult: PlaceResult

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(act)
        setContentView(R.layout.activity_forecast)
        placeResult = intent.getParcelableExtra<PlaceResult>(EXTRA_PLACE)
        forecastViewModel = ViewModelProviders.of(this, viewModelFactory).get(ForecastViewModel::class.java)
        val location = placeResult.geometry!!.location!!;
        forecastViewModel.getForecast(location.lat!!, location.lng!!).observe(this, Observer<Resource<Forecast>> { resource ->
            when (resource!!.resourceStatus) {
                ResourceStatus.SUCCESS -> {
                    forecastViewModel.saveForecast(placeResult.toPlace(), resource.data!!)
                    updateUI(resource.data)
                }
                ResourceStatus.ERROR -> Toast.makeText(this@ForecastActivity, "No forecast!!! :(", Toast.LENGTH_SHORT).show();
                ResourceStatus.LOADING -> Toast.makeText(this@ForecastActivity, "Loading!", Toast.LENGTH_SHORT).show();
            }
        })
    }

    private fun updateUI(forecast: Forecast) {
        forecast_locality.text = placeResult.name
        forecast_weather_icon.setImageResource(iconFromIconId(forecast.iconId))
        forecast_weather_description.text = forecast.description
        forecast_temperature_text.text = forecast.temperature.toString()
        forecast_wind_text.text = forecast.windSpeed.toString()
        forecast_summary_text.text = forecast.prediction
    }

    @DrawableRes private fun iconFromIconId(iconId: String): Int {
        return when (iconId) {
            "clear-day" -> R.drawable.clear_day
            "clear-night" -> R.drawable.clear_night
            "rain" -> R.drawable.rain
            "snow" -> R.drawable.snow
            "sleet" -> R.drawable.sleet
            "wind" -> R.drawable.wind
            "fog" -> R.drawable.fog
            "cloudy" -> R.drawable.cloudy
            "partly-cloudy-day" -> R.drawable.partly_cloudy_day
            "partly-cloudy-night" -> R.drawable.partly_cloudy_night
            else -> R.mipmap.ic_launcher
        }
    }
}