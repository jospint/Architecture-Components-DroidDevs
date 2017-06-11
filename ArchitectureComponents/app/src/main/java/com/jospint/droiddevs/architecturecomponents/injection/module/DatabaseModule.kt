package com.jospint.droiddevs.architecturecomponents.injection.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import com.jospint.droiddevs.architecturecomponents.db.AppDatabase
import android.arch.persistence.room.Room

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(application: Application): AppDatabase =
            Room.databaseBuilder(application.applicationContext, AppDatabase::class.java, "db").build()

}