package com.github.astat1cc.moviestesttask.movie_list.data

import com.github.astat1cc.moviestesttask.core.Abstract
import com.github.astat1cc.moviestesttask.movie_list.data.remote.entities.MovieDataEntity
import com.github.astat1cc.moviestesttask.movie_list.domain.MoviesResultDomain
import java.lang.Exception

sealed class MoviesResultData :
    Abstract.Object<MoviesResultDomain, MoviesResultDataToDomainMapper> {

    class Success(private val movies: List<MovieDataEntity>) : MoviesResultData() {

        override fun map(mapper: MoviesResultDataToDomainMapper): MoviesResultDomain =
            mapper.map(movies)
    }

    class Fail(private val e: Exception): MoviesResultData() {

        override fun map(mapper: MoviesResultDataToDomainMapper): MoviesResultDomain =
            mapper.map(e)
    }
}