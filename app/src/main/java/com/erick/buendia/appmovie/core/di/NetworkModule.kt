package com.erick.buendia.appmovie.core.di

import com.erick.buendia.appmovie.data.network.MovieApiClient
import com.erick.buendia.appmovie.data.network.TvApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providerRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providerApiMovie(retrofit: Retrofit): MovieApiClient{
        return retrofit.create(MovieApiClient::class.java)
    }

    @Singleton
    @Provides
    fun providerApiTv(retrofit: Retrofit):TvApiClient{
        return retrofit.create(TvApiClient::class.java)
    }
}