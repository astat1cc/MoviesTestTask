package com.github.astat1cc.moviestesttask.movie_list.data

import com.github.astat1cc.moviestesttask.core.Abstract
import com.github.astat1cc.moviestesttask.movie_list.domain.entities.MovieEntity

interface MovieDataEntityToDomainMapper : Abstract.Mapper {

    fun map(title: String, imageUrl: String, description: String): MovieEntity
}