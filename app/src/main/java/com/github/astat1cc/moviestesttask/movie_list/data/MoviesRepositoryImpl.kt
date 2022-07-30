package com.github.astat1cc.moviestesttask.movie_list.data

import com.github.astat1cc.moviestesttask.movie_list.data.remote.service.MovieListService
import com.github.astat1cc.moviestesttask.movie_list.domain.MoviesResultDomain
import com.github.astat1cc.moviestesttask.movie_list.domain.MoviesRepository
import java.lang.Exception
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val movieListService: MovieListService,
    private val mapper: MoviesResultDataToDomainMapper
) : MoviesRepository {

    override suspend fun fetchMovieList(offset: Int): MoviesResultDomain =
        try {
            val movies = movieListService.fetchMovieList(offset).results
            MoviesResultData.Success(movies).map(mapper)
        } catch (e: Exception) {
            MoviesResultData.Fail(e).map(mapper)
        }
}