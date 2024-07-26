package com.erick.buendia.appmovie.data.network

import com.erick.buendia.appmovie.core.RetrofitServiceFactory
import com.erick.buendia.appmovie.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call


class MovieService {
    private val retrofit = RetrofitServiceFactory.getMakeRetrofitService()
    suspend fun getMovies(): Movie? {


        return withContext(Dispatchers.IO) {
            val response = retrofit.create(MovieApiClient::class.java)
                .getAllMoviesNow("7e9c5fe2ffb6d1fa5631becb9cb79f60")

            response.body()
        }
    }
}
