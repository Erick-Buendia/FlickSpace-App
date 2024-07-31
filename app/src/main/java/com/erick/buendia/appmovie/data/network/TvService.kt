package com.erick.buendia.appmovie.data.network

import com.erick.buendia.appmovie.core.RetrofitServiceFactory
import com.erick.buendia.appmovie.data.model.Tv
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TvService {

    private val retrofit = RetrofitServiceFactory.getMakeRetrofitService()

    suspend fun getTv(): Tv? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(TvApiClient::class.java)
                .getAllTvNow( "7e9c5fe2ffb6d1fa5631becb9cb79f60" )
            response.body()
        }
    }
}
