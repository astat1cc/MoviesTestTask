package com.github.astat1cc.moviestesttask.movie_list.domain

import com.github.astat1cc.moviestesttask.core.Abstract
import com.github.astat1cc.moviestesttask.movie_list.presentation.entities.MovieUiEntity

interface MovieDomainEntityToUiMapper : Abstract.Mapper {

    fun map(title: String, imageUrl: String, description: String): MovieUiEntity
}