package com.erick.buendia.appmovie.data

import com.erick.buendia.appmovie.data.database.dao.FavoritesDao
import com.erick.buendia.appmovie.data.database.entities.FavoritesEntity
import javax.inject.Inject

class FavoritesRepository @Inject constructor(private val favoritesDao: FavoritesDao){

    suspend fun getFavoritesAll(): List<FavoritesEntity>{
       return favoritesDao.getAllFavorites()
    }
}