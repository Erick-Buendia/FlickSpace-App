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
import com.erick.buendia.appmovie.data.model.Tv
import com.erick.buendia.appmovie.data.model.TvResult
import com.erick.buendia.appmovie.ui.adapter.TvAdapter
import com.erick.buendia.appmovie.ui.viewmodel.TvFragmentViewModel
import com.erick.buendia.appmovie.ui.viewmodel.TvUiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val tvFragmentViewModel: TvFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        tvFragmentViewModel.onCreate()
        tvFragmentViewModel.tvModel.observe(viewLifecycleOwner, Observer {
            when (it) {
                TvUiState.Error -> ErrorResponse()
                TvUiState.Loading -> LondigResponse()
                is TvUiState.Success -> it.tv?.let { tv -> initRecycleViewTv(tv, view) }
            }
        })
    }


    private fun initRecycleViewTv(tv: Tv, view: View) {
        recyclerView = view.findViewById(R.id.recycler_tv)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = TvAdapter(
            tvList = tv.results,
            onClickTvListener = { tv -> navigationTvDetail(tv) },
            onClickAddFavorite = { tv -> addFavoriteTv(tv) })
    }

    private fun addFavoriteTv(tv: TvResult) {
        tvFragmentViewModel.addFavoriteTv(tv)
        Toast.makeText(context, "Se ha agregado ${tv.name} a favoritos", Toast.LENGTH_LONG).show()
    }

    private fun navigationTvDetail(tv: TvResult) {
        val intent = Intent(context, DetailTvActivity::class.java)
        intent.putExtra(DetailTvActivity.DETAIL_TV, tv)
        startActivity(intent)
    }

    private fun LondigResponse() {
        Toast.makeText(context, "Cargando la api", Toast.LENGTH_LONG).show()
    }

    private fun ErrorResponse() {
        Toast.makeText(context, "Error al conectar a la api", Toast.LENGTH_LONG).show()
    }

}