package com.erick.buendia.appmovie.data

import com.erick.buendia.appmovie.data.model.Tv
import com.erick.buendia.appmovie.data.network.TvService
import javax.inject.Inject

class TvRepository @Inject constructor(private  val api:TvService) {

    suspend fun getAllTvNow(): Tv? {
        val response = api.getTv()
        return response
    }
}