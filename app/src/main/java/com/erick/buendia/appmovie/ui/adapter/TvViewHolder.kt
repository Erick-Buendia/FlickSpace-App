package com.erick.buendia.appmovie.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.erick.buendia.appmovie.data.model.TvResult
import com.erick.buendia.appmovie.databinding.ItemListTvBinding

class TvViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val bindings = ItemListTvBinding.bind(view)

    fun render(
        tv: TvResult,
        onClickTvListener: (TvResult) -> Unit,
        onClickAddFavorite: (TvResult) -> Unit
    ){
        bindings.tvTitle.text = tv.name
        bindings.releaseDateTv.text = tv.first_air_date
        Glide.with(bindings.lyImageTv.context).load("https://image.tmdb.org/t/p/w500${tv.poster_path}").into(bindings.ivTv)
        itemView.setOnClickListener{onClickTvListener(tv)}
        bindings.addFavoriteTv.setOnClickListener{onClickAddFavorite(tv)}

    }
}