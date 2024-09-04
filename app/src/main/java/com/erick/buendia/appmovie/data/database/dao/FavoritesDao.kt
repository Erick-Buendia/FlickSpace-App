package com.erick.buendia.appmovie.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.erick.buendia.appmovie.data.database.entities.FavoritesEntity

@Dao
interface FavoritesDao {

    @Query("SELECT * FROM favorites_table")
    suspend fun getAllFavorites(): List<FavoritesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(favorites:List<FavoritesEntity>)
}