package com.erick.buendia.appmovie.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erick.buendia.appmovie.data.TvRepository
import com.erick.buendia.appmovie.data.model.Tv
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

sealed interface TvUiState {
    data class Success(val tv: Tv?) : TvUiState
    object Error : TvUiState
    object Loading : TvUiState
}

@HiltViewModel
class TvFragmentViewModel @Inject constructor(var getTvRepository:TvRepository)  : ViewModel() {

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