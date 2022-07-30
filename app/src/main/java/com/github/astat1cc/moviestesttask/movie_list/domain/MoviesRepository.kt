package com.github.astat1cc.moviestesttask.movie_list.domain

interface MoviesRepository {

    suspend fun fetchMovieList(offset: Int): MoviesResultDomain
}