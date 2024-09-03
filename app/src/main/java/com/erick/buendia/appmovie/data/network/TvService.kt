package com.erick.buendia.appmovie.data.network

import com.erick.buendia.appmovie.data.model.Tv
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TvService @Inject constructor(val api: TvApiClient) {

    suspend fun getTv(): Tv? {
        return withContext(Dispatchers.IO) {
            val response = api.getAllTvNow("7e9c5fe2ffb6d1fa5631becb9cb79f60")
            response.body()
        }
    }
}
