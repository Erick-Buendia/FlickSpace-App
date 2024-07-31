package com.erick.buendia.appmovie.data.network

import com.erick.buendia.appmovie.data.model.Tv
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TvApiClient {

    @GET("trending/tv/day")
    suspend fun getAllTvNow(
        @Query("api_key") apiKey: String,


    ): Response<Tv>
}