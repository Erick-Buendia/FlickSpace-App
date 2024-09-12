package com.erick.buendia.appmovie.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erick.buendia.appmovie.R
import com.erick.buendia.appmovie.data.database.entities.FavoritesEntity
import com.erick.buendia.appmovie.ui.adapter.FavoriteAdapter
import com.erick.buendia.appmovie.ui.viewmodel.FavoritesFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class FavoritesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val favoritesFragmentViewModel: FavoritesFragmentViewModel by viewModels()
        favoritesFragmentViewModel.getFavorites()
        favoritesFragmentViewModel.favoritesModel.observe(viewLifecycleOwner, Observer {
            initRecycleViewFavorite(it, view)
        })
    }


    fun initRecycleViewFavorite(favorites: List<FavoritesEntity>, view: View) {
        recyclerView = view.findViewById(R.id.recycler_favorites)
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        recyclerView.adapter = FavoriteAdapter(favorites)

    }
}