package com.erick.buendia.appmovie.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erick.buendia.appmovie.R
import com.erick.buendia.appmovie.data.model.Movie
import com.erick.buendia.appmovie.data.model.Result
import com.erick.buendia.appmovie.ui.adapter.MovieAdapter
import com.erick.buendia.appmovie.ui.viewmodel.MainViewModel
import com.erick.buendia.appmovie.ui.viewmodel.MovieUiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        mainViewModel.onCreate()
        mainViewModel.moviesModel.observe(viewLifecycleOwner, Observer {
            when (it) {
                MovieUiState.Error -> ErrorResponse()
                MovieUiState.Loading -> LoandingResponse()
                is MovieUiState.Success -> it.movie?.let { movie ->
                    initRecycleViewMovie(
                        movie,
                        view
                    )
                }
            }
        })

    }

    fun initRecycleViewMovie(movies: Movie, view: View) {
        recyclerView = view.findViewById(R.id.recycler_movies)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = MovieAdapter(moviesList = movies.results,
            onClickMovieListener = { movie -> navigationMovieDetail(movie) },
            onClickAddFavorite = { movie -> addFavoriteMovie(movie) })

    }

    private fun addFavoriteMovie(movies: Result){
        Toast.makeText(context, "Se ha agrego ${movies.title} a favoritos", Toast.LENGTH_LONG).show()
        mainViewModel.addFavoriteMovie(movies)
    }

    private fun navigationMovieDetail(movie: Result) {
        val intent = Intent(context, DetailMovieActivity::class.java)
        intent.putExtra(DetailMovieActivity.DETAIL_MOVIE, movie)
        startActivity(intent)
    }

    private fun ErrorResponse() {
        Toast.makeText(context, "Error al conectar a la api", Toast.LENGTH_LONG).show()
    }

    private fun LoandingResponse() {
        Toast.makeText(context, "Cargando api", Toast.LENGTH_LONG).show()
    }

}