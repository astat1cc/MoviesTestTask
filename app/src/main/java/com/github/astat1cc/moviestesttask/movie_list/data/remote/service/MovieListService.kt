package com.github.astat1cc.moviestesttask.movie_list.data.remote.service

import com.github.astat1cc.moviestesttask.movie_list.data.remote.entities.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieListService {

    @GET("reviews/all.json")
    suspend fun fetchMovieList(
        @Query(value = "offset") offset: Int,
        @Query(value = "api-key") apiKey: String = "y8KdYZjP2POaReybSvb2CGu2vH2wqo9S"
    ): MoviesResponse
}