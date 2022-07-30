package com.github.astat1cc.moviestesttask.movie_list.domain

import com.github.astat1cc.moviestesttask.core.Abstract
import com.github.astat1cc.moviestesttask.movie_list.domain.entities.MovieEntity
import com.github.astat1cc.moviestesttask.movie_list.presentation.entities.MoviesResultUi

sealed class MoviesResultDomain :
    Abstract.Object<MoviesResultUi, MoviesResultDomainToUiMapper> {

    class Success(private val movies: List<MovieEntity>) : MoviesResultDomain() {

        override fun map(mapper: MoviesResultDomainToUiMapper): MoviesResultUi =
            mapper.map(movies)
    }

    class Fail(private val errorType: ErrorType) : MoviesResultDomain() {

        override fun map(mapper: MoviesResultDomainToUiMapper): MoviesResultUi =
            mapper.map(errorType)
    }
}