package com.erick.buendia.appmovie.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erick.buendia.appmovie.data.FavoritesRepository
import com.erick.buendia.appmovie.data.database.dao.FavoritesDao
import com.erick.buendia.appmovie.data.database.entities.FavoritesEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesFragmentViewModel @Inject constructor(private  val getFavoritesRepository: FavoritesRepository) : ViewModel(){

    var favoritesModel=  MutableLiveData<List<FavoritesEntity>>()
    fun getFavorites(){
        viewModelScope.launch(Dispatchers.IO) {
            favoritesModel.postValue(getFavoritesRepository.getFavoritesAll())
        }
    }


}
