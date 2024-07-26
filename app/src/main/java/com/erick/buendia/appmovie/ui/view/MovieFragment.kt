package com.erick.buendia.appmovie.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erick.buendia.appmovie.R
import com.erick.buendia.appmovie.data.model.Movie
import com.erick.buendia.appmovie.ui.adapter.MovieAdapter
import com.erick.buendia.appmovie.ui.viewmodel.MainViewModel
import com.erick.buendia.appmovie.ui.viewmodel.MovieUiState

class MovieFragment : Fragment() {
    private lateinit  var  recyclerView:RecyclerView
    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val mainViewModel: MainViewModel by viewModels()
        mainViewModel.onCreate()
        mainViewModel.moviesModel.observe(viewLifecycleOwner, Observer {
            when (it) {
                MovieUiState.Error -> ErrorResponse()
                MovieUiState.Loading -> LoandingResponse()
                is MovieUiState.Success -> it.movie?.let { movie -> initRecycleViewMovie(movie, view) }
            }
        })

    }

    fun initRecycleViewMovie(movies: Movie, view: View) {
        Log.d("Log", "Estra")
        recyclerView = view.findViewById(R.id.recycler_movies)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = MovieAdapter(movies.results)

    }

    fun ErrorResponse() {
        Toast.makeText(context, "Error al conectar a la api", Toast.LENGTH_LONG).show()
    }

    fun LoandingResponse() {
        Toast.makeText(context, "Cargando api", Toast.LENGTH_LONG).show()
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MovieFragment().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }
}