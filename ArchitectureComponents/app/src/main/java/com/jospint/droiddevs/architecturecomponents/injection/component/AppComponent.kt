package com.jospint.droiddevs.architecturecomponents.injection.component

import android.app.Application
import com.jospint.droiddevs.architecturecomponents.App
import com.jospint.droiddevs.architecturecomponents.data.darksky.DarkSkyModule
import com.jospint.droiddevs.architecturecomponents.data.googlemaps.GoogleMapsModule
import com.jospint.droiddevs.architecturecomponents.injection.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AndroidInjectorsModule::class,
        AppModule::class,
        ViewModelsModule::class,
        DatabaseModule::class,
        NetworkModule::class,
        DarkSkyModule::class,
        GoogleMapsModule::class
))
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {

        @BindsInstance abstract fun injectApplication(app: Application): Builder
    }


}