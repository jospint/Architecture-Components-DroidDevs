package com.jospint.droiddevs.architecturecomponents.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.jospint.droiddevs.architecturecomponents.model.Place

@Dao
interface ForecastDao {

    @Query("SELECT * FROM place where id = :p0")
    fun getPlace(id:String) : LiveData<Place>

    @Insert
    fun insertPlace(place: Place)


}