package com.github.astat1cc.moviestesttask.movie_list.domain

import com.github.astat1cc.moviestesttask.movie_list.data.MovieDataEntityToDomainMapper
import com.github.astat1cc.moviestesttask.movie_list.data.MoviesResultDataToDomainMapper
import com.github.astat1cc.moviestesttask.movie_list.data.remote.entities.MovieDataEntity
import retrofit2.HttpException
import java.net.UnknownHostException
import javax.inject.Inject

class MoviesResultDataToDomainMapperImpl @Inject constructor(
    private val mapper: MovieDataEntityToDomainMapper
) : MoviesResultDataToDomainMapper {

    override fun map(moviesData: List<MovieDataEntity>): MoviesResultDomain {
        val moviesDomain = moviesData.map { movieData ->
            movieData.map(mapper)
        }
        return MoviesResultDomain.Success(moviesDomain)
    }

    override fun map(e: Exception): MoviesResultDomain {
        val errorType = when (e) {
            is UnknownHostException -> ErrorType.NO_CONNECTION
            is HttpException -> ErrorType.SERVICE_UNAVAILABLE
            else -> ErrorType.GENERIC_EXCEPTION
        }
        return MoviesResultDomain.Fail(errorType)
    }
}