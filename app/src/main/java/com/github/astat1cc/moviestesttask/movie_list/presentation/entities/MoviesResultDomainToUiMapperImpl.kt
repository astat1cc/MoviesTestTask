package com.github.astat1cc.moviestesttask.movie_list.presentation.entities

import com.github.astat1cc.moviestesttask.R
import com.github.astat1cc.moviestesttask.movie_list.domain.ErrorType
import com.github.astat1cc.moviestesttask.movie_list.domain.MovieDomainEntityToUiMapper
import com.github.astat1cc.moviestesttask.movie_list.domain.MoviesResultDomainToUiMapper
import com.github.astat1cc.moviestesttask.movie_list.domain.entities.MovieEntity
import com.github.astat1cc.moviestesttask.movie_list.presentation.utils.ResourceProvider
import javax.inject.Inject

class MoviesResultDomainToUiMapperImpl @Inject constructor(
    private val resourceProvider: ResourceProvider,
    private val mapper: MovieDomainEntityToUiMapper
) : MoviesResultDomainToUiMapper {

    override fun map(moviesDomain: List<MovieEntity>): MoviesResultUi {
        val moviesUi = moviesDomain.map { movie ->
            movie.map(mapper)
        }
        return MoviesResultUi.Success(moviesUi)
    }

    override fun map(errorType: ErrorType): MoviesResultUi {
        val errorMessage = when (errorType) {
            ErrorType.NO_CONNECTION -> resourceProvider.getString(R.string.no_connection_message)
            ErrorType.SERVICE_UNAVAILABLE -> resourceProvider.getString(R.string.service_unavailable_message)
            ErrorType.GENERIC_EXCEPTION -> resourceProvider.getString(R.string.something_went_wrong_message)
        }
        return MoviesResultUi.Fail(errorMessage)
    }
}