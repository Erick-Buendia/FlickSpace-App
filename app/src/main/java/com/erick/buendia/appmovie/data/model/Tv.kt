package com.erick.buendia.appmovie.data.model

data class Tv(
    val page: Int,
    val results: List<TvResult>,
    val total_pages: Int,
    val total_results: Int
)