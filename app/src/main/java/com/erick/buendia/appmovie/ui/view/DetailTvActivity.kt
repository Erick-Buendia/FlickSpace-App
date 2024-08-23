package com.erick.buendia.appmovie.ui.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.erick.buendia.appmovie.R
import com.erick.buendia.appmovie.data.model.TvResult
import com.erick.buendia.appmovie.databinding.ActivityDetailMovieBinding
import com.erick.buendia.appmovie.databinding.ActivityDetailTvBinding

class DetailTvActivity : AppCompatActivity() {

    companion object{
        const val DETAIL_TV = "DetailTvActivity:result"
    }

    private  lateinit var binding: ActivityDetailTvBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        setSupportActionBar(binding.tvToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val tv = intent.getParcelableExtra<TvResult>(DETAIL_TV)

        if (tv != null){
            binding.tvDetailTitle.text = tv.name
            binding.tvDetailDate.text = tv.first_air_date
            binding.tvDetailDescription.text = tv.overview
            Glide.with(binding.tvDetailImage.context).load("https://image.tmdb.org/t/p/w780${tv.poster_path}").into(binding.tvDetailImage)
        }
    }
}