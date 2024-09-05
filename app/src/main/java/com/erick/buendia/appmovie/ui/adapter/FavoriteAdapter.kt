package com.erick.buendia.appmovie.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erick.buendia.appmovie.R
import com.erick.buendia.appmovie.data.database.entities.FavoritesEntity

class FavoriteAdapter(private val favoritesList: List<FavoritesEntity>) :
    RecyclerView.Adapter<FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FavoriteViewHolder(
            layoutInflater.inflate(
                R.layout.item_list_favorite,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val item = favoritesList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return favoritesList.size
    }
}