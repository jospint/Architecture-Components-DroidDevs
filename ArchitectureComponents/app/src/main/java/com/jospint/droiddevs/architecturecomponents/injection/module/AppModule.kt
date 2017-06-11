package com.jospint.droiddevs.architecturecomponents.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext (application: Application): Context = application.applicationContext
}