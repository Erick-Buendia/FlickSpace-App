package com.erick.buendia.appmovie.ui.view


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.bumptech.glide.Glide

import com.erick.buendia.appmovie.R
import com.erick.buendia.appmovie.data.model.Result
import com.erick.buendia.appmovie.databinding.ActivityDetailMovieBinding


class DetailMovieActivity : AppCompatActivity() {

    companion object{
        const val DETAIL_MOVIE = "DetailMovieActivity:result"
    }

    private   lateinit  var binding: ActivityDetailMovieBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val movie =   intent.getParcelableExtra<Result>(DETAIL_MOVIE)
        if (movie != null) {
            binding.detailTitle.text = movie.title
            binding.detailDate.text = movie.release_date
            binding.detailDescription.text = movie.overview
            Glide.with(binding.detailImage.context).load("https://image.tmdb.org/t/p/w780${movie.poster_path}").into(binding.detailImage)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
      return super.onSupportNavigateUp()
    }
}