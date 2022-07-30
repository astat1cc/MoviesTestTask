package com.github.astat1cc.moviestesttask.movie_list.presentation.entities

import com.github.astat1cc.moviestesttask.core.Abstract

sealed class MoviesResultUi :
    Abstract.Object<Unit, Abstract.Mapper.Empty> {

    class Success(val movies: List<MovieUiEntity>) : MoviesResultUi() {

        override fun map(mapper: Abstract.Mapper.Empty) {}
    }

    class Fail(
        val errorMessage: String,
    ) : MoviesResultUi() {

        override fun map(mapper: Abstract.Mapper.Empty) {}
    }

    object Loading : MoviesResultUi() {

        override fun map(mapper: Abstract.Mapper.Empty) {}
    }
}