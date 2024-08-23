package com.erick.buendia.appmovie.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erick.buendia.appmovie.R
import com.erick.buendia.appmovie.data.model.Result

class MovieAdapter(private val moviesList: List<Result>, private  val movieListener: (Result) -> Unit) : RecyclerView.Adapter<MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return  MovieViewHolder(layoutInflater.inflate(R.layout.item_list_movie, parent, false))
    }



    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = moviesList[position]
        holder.render(item)
        holder.itemView.setOnClickListener { movieListener(item) }
    }

    override fun getItemCount(): Int {
      return  moviesList.size
    }
}