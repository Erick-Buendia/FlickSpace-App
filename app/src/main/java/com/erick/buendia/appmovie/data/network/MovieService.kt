package com.erick.buendia.appmovie.data.network

import com.erick.buendia.appmovie.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class MovieService @Inject constructor(private val api: MovieApiClient){

    suspend fun getMovies(): Movie? {
        return withContext(Dispatchers.IO) {
            val response = api.getAllMoviesNow("7e9c5fe2ffb6d1fa5631becb9cb79f60")
            response.body()
        }
    }
}
