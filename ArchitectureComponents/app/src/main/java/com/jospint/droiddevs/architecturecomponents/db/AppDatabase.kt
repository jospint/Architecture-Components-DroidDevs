package com.jospint.droiddevs.architecturecomponents.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.jospint.droiddevs.architecturecomponents.model.Place

@Database(entities = arrayOf(Place::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun ForecastDao(): ForecastDao
}