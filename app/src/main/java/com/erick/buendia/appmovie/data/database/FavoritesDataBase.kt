package com.erick.buendia.appmovie.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.erick.buendia.appmovie.data.database.dao.FavoritesDao
import com.erick.buendia.appmovie.data.database.entities.FavoritesEntity

@Database(entities = [FavoritesEntity::class], version = 1)
abstract class FavoritesDataBase: RoomDatabase() {

    abstract fun getFavoritesDao():FavoritesDao
}