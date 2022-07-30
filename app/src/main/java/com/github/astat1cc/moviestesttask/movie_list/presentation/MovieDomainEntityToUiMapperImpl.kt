package com.github.astat1cc.moviestesttask.movie_list.presentation

import com.github.astat1cc.moviestesttask.movie_list.domain.MovieDomainEntityToUiMapper
import com.github.astat1cc.moviestesttask.movie_list.presentation.entities.MovieUiEntity
import javax.inject.Inject

class MovieDomainEntityToUiMapperImpl @Inject constructor() : MovieDomainEntityToUiMapper {

    override fun map(title: String, imageUrl: String, description: String): MovieUiEntity =
        MovieUiEntity.Success(title, imageUrl, description)
}