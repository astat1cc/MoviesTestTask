package com.github.astat1cc.moviestesttask.movie_list.presentation.entities

import com.github.astat1cc.moviestesttask.movie_list.domain.entities.MovieEntity

sealed class MovieUiEntity {

    data class Success(
        val title: String,
        val imageUrl: String,
        val description: String
    ) : MovieUiEntity() {

        companion object {

            fun fromDomain(movie: MovieEntity) = with(movie) {
                MovieUiEntity.Success(title = title, imageUrl = imageUrl, description = description)
            }
        }
    }

    object Loading : MovieUiEntity()
}