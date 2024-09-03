package com.erick.buendia.appmovie.data

import com.erick.buendia.appmovie.data.model.Movie
import com.erick.buendia.appmovie.data.network.MovieService
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val api: MovieService) {

    suspend fun getAllMoviesNow(): Movie? {

        val response = api.getMovies()

        return response
    }
}