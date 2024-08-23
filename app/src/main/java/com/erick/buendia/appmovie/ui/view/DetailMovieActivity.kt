package com.erick.buendia.appmovie.ui.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

import com.erick.buendia.appmovie.R
import com.erick.buendia.appmovie.data.model.Result
import com.erick.buendia.appmovie.databinding.ActivityDetailMovieBinding


class DetailMovieActivity : AppCompatActivity() {

    companion object{
        const val DETAIL_MOVIE = "DetailMovieActivity:result"
    }

    private   lateinit  var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    //        supportActionBar.(
    //            MaterialColors.getColor(appBarLayout, com.google.android.material.R.attr.colorSurface))

    //      val movie = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
    //          intent.getParcelableExtra(DETAIL_MOVIE, T::class.java)
    //
    //      } else {
        val movie =   intent.getParcelableExtra<Result>(DETAIL_MOVIE)
//      }

        if (movie != null) {
            binding.detailTitle.text = movie.title
            binding.detailDate.text = movie.release_date
            binding.detailDescription.text = movie.overview
            Glide.with(binding.detailImage.context).load("https://image.tmdb.org/t/p/w780${movie.poster_path}").into(binding.detailImage)

        }


    }

    override fun onSupportNavigateUp(): Boolean {
        return true
    }
}