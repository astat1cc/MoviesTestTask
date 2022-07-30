package com.github.astat1cc.moviestesttask.movie_list.data

import com.github.astat1cc.moviestesttask.core.Abstract
import com.github.astat1cc.moviestesttask.movie_list.data.remote.entities.MovieDataEntity
import com.github.astat1cc.moviestesttask.movie_list.domain.MoviesResultDomain

interface MoviesResultDataToDomainMapper : Abstract.Mapper {

    fun map(moviesData: List<MovieDataEntity>): MoviesResultDomain

    fun map(e: Exception): MoviesResultDomain
}