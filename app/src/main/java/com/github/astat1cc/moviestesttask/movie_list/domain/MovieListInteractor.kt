package com.github.astat1cc.moviestesttask.movie_list.domain

import javax.inject.Inject

interface MovieListInteractor {

    suspend fun fetchMovieList(offset: Int): MoviesResultDomain
}

class MovieListInteractorImpl @Inject constructor(
    private val repository: MoviesRepository
) : MovieListInteractor {

    override suspend fun fetchMovieList(offset: Int): MoviesResultDomain =
        repository.fetchMovieList(offset)
}