package com.erick.buendia.appmovie.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites_table")
data class FavoritesEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo("name")
    val name: String,

    @ColumnInfo(name = "poster_path")
    val posterPath: String
)
