package com.jospint.droiddevs.architecturecomponents.injection.module

import dagger.Module
import android.arch.lifecycle.ViewModel
import com.jospint.droiddevs.architecturecomponents.viewmodel.ForecastViewModel
import dagger.multibindings.IntoMap
import dagger.Binds
import android.arch.lifecycle.ViewModelProvider
import com.jospint.droiddevs.architecturecomponents.injection.annotation.ViewModelKey
import com.jospint.droiddevs.architecturecomponents.util.ViewModelFactory
import com.jospint.droiddevs.architecturecomponents.viewmodel.PlaceViewModel

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(PlaceViewModel::class)
    abstract fun bindPlaceViewModel(placeViewModel: PlaceViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ForecastViewModel::class)
    abstract fun bindForecastViewModel(forecastViewModel: ForecastViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}