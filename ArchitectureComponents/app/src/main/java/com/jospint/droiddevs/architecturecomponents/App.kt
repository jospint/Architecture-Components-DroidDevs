package com.jospint.droiddevs.architecturecomponents

import com.jospint.droiddevs.architecturecomponents.injection.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun applicationInjector(): AndroidInjector<App> {
        return DaggerAppComponent.builder().injectApplication(this@App).create(this@App)
    }

}