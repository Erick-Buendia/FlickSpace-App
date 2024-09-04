package com.erick.buendia.appmovie.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.erick.buendia.appmovie.R
import com.erick.buendia.appmovie.ui.viewmodel.FavoritesFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class FavoritesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val favoritesFragmentViewModel : FavoritesFragmentViewModel by viewModels()
        favoritesFragmentViewModel.getFavorites()
        favoritesFragmentViewModel.favoritesModel.observe(viewLifecycleOwner, Observer {

        })
    }
}