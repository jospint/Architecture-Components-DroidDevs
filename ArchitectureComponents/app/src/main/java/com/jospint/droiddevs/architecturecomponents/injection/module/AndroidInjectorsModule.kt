package com.jospint.droiddevs.architecturecomponents.injection.module

import com.jospint.droiddevs.architecturecomponents.injection.annotation.ActivityScope
import com.jospint.droiddevs.architecturecomponents.view.forecast.ForecastActivity
import com.jospint.droiddevs.architecturecomponents.view.forecast.ForecastModule
import com.jospint.droiddevs.architecturecomponents.view.start.StartActivity
import com.jospint.droiddevs.architecturecomponents.view.start.StartModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidInjectorsModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(StartModule::class))
    abstract fun contributeStartActivity(): StartActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(ForecastModule::class))
    abstract fun contributeForecastActivity(): ForecastActivity
}