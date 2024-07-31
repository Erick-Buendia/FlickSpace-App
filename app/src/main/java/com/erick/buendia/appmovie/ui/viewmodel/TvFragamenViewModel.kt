package com.erick.buendia.appmovie.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erick.buendia.appmovie.data.TvRepository
import com.erick.buendia.appmovie.data.model.Tv
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface TvUiState {
    data class Success(val tv: Tv?) : TvUiState
    object Error : TvUiState
    object Loading : TvUiState
}

class TvFragmentViewModel : ViewModel() {

    private var getTvRepository = TvRepository()
    val tvModel = MutableLiveData<TvUiState>()

    fun onCreate() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = getTvRepository.getAllTvNow()
                tvModel.postValue(TvUiState.Success(result))
            } catch (e: IOException) {
                tvModel.postValue(TvUiState.Error)
            } catch (e: HttpException) {
                tvModel.postValue(TvUiState.Error)
            }
        }

    }
}