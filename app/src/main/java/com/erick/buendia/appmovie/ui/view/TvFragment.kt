package com.erick.buendia.appmovie.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.erick.buendia.appmovie.R
import com.erick.buendia.appmovie.data.model.Tv
import com.erick.buendia.appmovie.ui.viewmodel.MovieUiState
import com.erick.buendia.appmovie.ui.viewmodel.TvFragmentViewModel
import com.erick.buendia.appmovie.ui.viewmodel.TvUiState


//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

class TvFragment : Fragment() {

//    private var param1: String? = null
//    private var param2: String? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tvFragmentViewModel: TvFragmentViewModel by viewModels()
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


    }

    private fun LondigResponse() {
        Toast.makeText(context, "Cargando la api", Toast.LENGTH_LONG).show()
    }

    private fun ErrorResponse() {
        Toast.makeText(context, "Error al conectar a la api", Toast.LENGTH_LONG).show()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TvFragment().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }
}