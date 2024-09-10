package com.erick.buendia.appmovie.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erick.buendia.appmovie.R
import com.erick.buendia.appmovie.data.model.TvResult

class TvAdapter(private val tvList: List<TvResult>, private  val onClickTvListener: (TvResult) -> Unit, private val onClickAddFavorite: (TvResult) -> Unit) : RecyclerView.Adapter<TvViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val layoutInflater =  LayoutInflater.from(parent.context)
        return TvViewHolder(layoutInflater.inflate(R.layout.item_list_tv, parent, false))
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val item = tvList[position]
        holder.render(item, onClickTvListener, onClickAddFavorite)

    }

    override fun getItemCount(): Int {
        return tvList.size
    }
}