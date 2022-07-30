package com.github.astat1cc.moviestesttask.movie_list.domain

import com.github.astat1cc.moviestesttask.core.Abstract
import com.github.astat1cc.moviestesttask.movie_list.domain.entities.MovieEntity
import com.github.astat1cc.moviestesttask.movie_list.presentation.entities.MoviesResultUi

interface MoviesResultDomainToUiMapper : Abstract.Mapper {

    fun map(moviesDomain: List<MovieEntity>): MoviesResultUi

    fun map(errorType: ErrorType): MoviesResultUi
}