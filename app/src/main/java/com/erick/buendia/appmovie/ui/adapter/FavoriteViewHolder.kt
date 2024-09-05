package com.erick.buendia.appmovie.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.erick.buendia.appmovie.data.database.entities.FavoritesEntity
import com.erick.buendia.appmovie.databinding.ItemListFavoriteBinding

class FavoriteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val bindings = ItemListFavoriteBinding.bind(view)
    fun render(favorite: FavoritesEntity) {
        Glide.with(bindings.ivFavorite.context)
            .load("https://image.tmdb.org/t/p/w500${favorite.posterPath}").into(bindings.ivFavorite)
    }
}