package com.jospint.droiddevs.architecturecomponents.injection.module

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import com.jospint.droiddevs.architecturecomponents.db.AppDatabase
import android.arch.persistence.room.Room
import android.content.Context

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(applicationContext: Context): AppDatabase =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "db").build()

}