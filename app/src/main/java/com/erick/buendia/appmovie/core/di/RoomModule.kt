package com.erick.buendia.appmovie.core.di

import android.content.Context
import androidx.room.Room
import com.erick.buendia.appmovie.data.database.FavoritesDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val FAVORITES_DATABASE_NAME = "favorites_database"

    @Singleton
    @Provides
    fun providerRoom(@ApplicationContext context: Context): FavoritesDataBase {
        return Room.databaseBuilder(context, FavoritesDataBase::class.java, FAVORITES_DATABASE_NAME)
            .build()
    }

    @Singleton
    @Provides
    fun providerFavoritesDao(db: FavoritesDataBase) = db.getFavoritesDao()
}