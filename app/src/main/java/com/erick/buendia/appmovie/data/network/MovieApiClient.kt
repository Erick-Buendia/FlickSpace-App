package com.erick.buendia.appmovie.data.network

import com.erick.buendia.appmovie.data.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiClient {

    @GET("movie/now_playing")
    suspend fun getAllMoviesNow(
        @Query("api_key") apiKey: String
    ):Response <Movie>
}

