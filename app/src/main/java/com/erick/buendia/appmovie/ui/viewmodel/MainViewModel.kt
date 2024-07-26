package com.erick.buendia.appmovie.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.erick.buendia.appmovie.data.model.Movie
import kotlinx.coroutines.Dispatchers

import androidx.lifecycle.viewModelScope
import com.erick.buendia.appmovie.data.MoviesRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface MovieUiState {
    data class Success(val movie: Movie?) : MovieUiState
    object Error : MovieUiState
    object Loading : MovieUiState
}

class MainViewModel : ViewModel() {


    //  var moviesModel: MovieUiState by mutableStateOf(MovieUiState.Loading)
    private var getMoviesRepository = MoviesRepository()
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
}