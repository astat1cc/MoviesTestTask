package com.github.astat1cc.moviestesttask.movie_list.data.remote.entities

import com.github.astat1cc.moviestesttask.core.Abstract
import com.github.astat1cc.moviestesttask.movie_list.data.MovieDataEntityToDomainMapper
import com.github.astat1cc.moviestesttask.movie_list.domain.entities.MovieEntity

data class MovieDataEntity(
    val display_title: String,
    val multimedia: Multimedia,
    val summary_short: String
) : Abstract.Object<MovieEntity, MovieDataEntityToDomainMapper> {

    override fun map(mapper: MovieDataEntityToDomainMapper): MovieEntity =
        mapper.map(
            title = display_title,
            imageUrl = multimedia.src,
            description = summary_short
        )
}