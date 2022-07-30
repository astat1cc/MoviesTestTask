package com.github.astat1cc.moviestesttask.movie_list.domain.entities

import com.github.astat1cc.moviestesttask.core.Abstract
import com.github.astat1cc.moviestesttask.movie_list.domain.MovieDomainEntityToUiMapper
import com.github.astat1cc.moviestesttask.movie_list.presentation.entities.MovieUiEntity

data class MovieEntity(
    val title: String,
    val imageUrl: String,
    val description: String
) : Abstract.Object<MovieUiEntity, MovieDomainEntityToUiMapper> {

    override fun map(mapper: MovieDomainEntityToUiMapper): MovieUiEntity =
        mapper.map(title = title, imageUrl = imageUrl, description = description)
}