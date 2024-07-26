package com.erick.buendia.appmovie.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.erick.buendia.appmovie.data.model.Result
import com.erick.buendia.appmovie.databinding.ItemListMovieBinding

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val bindings = ItemListMovieBinding.bind(view)

    fun render(movie: Result) {
        bindings.tvTitle.text = movie.title

        bindings.releaseDate.text = movie.release_date

        Glide.with(bindings.ivMovie.context).load("https://image.tmdb.org/t/p/w500${movie.poster_path}").into(bindings.ivMovie)
    }
}