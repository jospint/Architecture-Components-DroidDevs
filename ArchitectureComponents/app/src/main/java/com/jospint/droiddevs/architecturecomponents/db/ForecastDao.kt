package com.jospint.droiddevs.architecturecomponents.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.jospint.droiddevs.architecturecomponents.model.Place

@Dao
interface ForecastDao {

    @Query("SELECT * FROM place where id = :p0")
    fun getPlace(id:String) : LiveData<Place>

    @Insert(onConflict = REPLACE)
    fun insertPlace(place: Place)

}