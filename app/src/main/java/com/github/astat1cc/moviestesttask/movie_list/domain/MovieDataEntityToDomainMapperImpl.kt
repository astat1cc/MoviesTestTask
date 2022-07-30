package com.github.astat1cc.moviestesttask.movie_list.domain

import com.github.astat1cc.moviestesttask.movie_list.data.MovieDataEntityToDomainMapper
import com.github.astat1cc.moviestesttask.movie_list.domain.entities.MovieEntity
import javax.inject.Inject

class MovieDataEntityToDomainMapperImpl @Inject constructor() : MovieDataEntityToDomainMapper {

    override fun map(title: String, imageUrl: String, description: String): MovieEntity =
        MovieEntity(title, imageUrl, description)
}