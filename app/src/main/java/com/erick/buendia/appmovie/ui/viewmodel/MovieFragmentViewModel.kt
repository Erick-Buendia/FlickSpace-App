package com.erick.buendia.appmovie.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.erick.buendia.appmovie.data.model.Movie
import kotlinx.coroutines.Dispatchers

import androidx.lifecycle.viewModelScope
import com.erick.buendia.appmovie.data.FavoritesRepository
import com.erick.buendia.appmovie.data.MoviesRepository
import com.erick.buendia.appmovie.data.database.entities.FavoritesEntity
import com.erick.buendia.appmovie.data.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

sealed interface MovieUiState {
    data class Success(val movie: Movie?) : MovieUiState
    object Error : MovieUiState
    object Loading : MovieUiState
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private var getMoviesRepository: MoviesRepository,
    private var getFavoriteRepository: FavoritesRepository
) : ViewModel() {

    // private var getMoviesRepository = MoviesRepository()
    val moviesModel = MutableLiveData<MovieUiState>()

    fun onCreate() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = getMoviesRepository.getAllMoviesNow()
                moviesModel.postValue(MovieUiState.Success(result))
            } catch (e: IOException) {
                moviesModel.postValue(MovieUiState.Error)
            } catch (e: HttpException) {
                moviesModel.postValue(MovieUiState.Error)
            }

        }
    }

    fun addFavoriteMovie(movie: Result) {
        val favorites = FavoritesEntity(
            movie.id,
            movie.title,
            movie.poster_path
        )
        viewModelScope.launch(Dispatchers.IO) {
            getFavoriteRepository.addFavorite(favorites)
        }
    }

}