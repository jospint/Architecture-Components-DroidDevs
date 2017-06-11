package com.jospint.droiddevs.architecturecomponents.injection.component

import com.jospint.droiddevs.architecturecomponents.App
import com.jospint.droiddevs.architecturecomponents.data.darksky.DarkSkyModule
import com.jospint.droiddevs.architecturecomponents.data.googlemaps.GoogleMapsModule
import com.jospint.droiddevs.architecturecomponents.injection.module.NetworkModule
import com.jospint.droiddevs.architecturecomponents.injection.module.AndroidInjectorsModule
import com.jospint.droiddevs.architecturecomponents.injection.module.DatabaseModule
import com.jospint.droiddevs.architecturecomponents.injection.module.ViewModelsModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AndroidInjectorsModule::class,
        ViewModelsModule::class,
        DatabaseModule::class,
        NetworkModule::class,
        DarkSkyModule::class,
        GoogleMapsModule::class
))
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

}