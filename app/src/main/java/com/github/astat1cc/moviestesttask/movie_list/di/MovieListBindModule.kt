package com.github.astat1cc.moviestesttask.movie_list.di

import com.github.astat1cc.moviestesttask.movie_list.data.MovieDataEntityToDomainMapper
import com.github.astat1cc.moviestesttask.movie_list.data.MoviesResultDataToDomainMapper
import com.github.astat1cc.moviestesttask.movie_list.data.MoviesRepositoryImpl
import com.github.astat1cc.moviestesttask.movie_list.domain.*
import com.github.astat1cc.moviestesttask.movie_list.presentation.MovieDomainEntityToUiMapperImpl
import com.github.astat1cc.moviestesttask.movie_list.presentation.entities.MoviesResultDomainToUiMapperImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Suppress("FunctionName")
@Module
interface MovieListBindModule {

    @Singleton
    @Binds
    fun bindMoviesListRepositoryImpl_to_MoviesRepository(
        repositoryImpl: MoviesRepositoryImpl
    ): MoviesRepository

    @Binds
    fun bindMovieListInteractorImpl_to_MovieListInteractor(
        interactorImpl: MovieListInteractorImpl
    ): MovieListInteractor

    @Binds
    fun bindMovieListDataToDomainMapperImpl_toMovieListDataToDomainMapper(
        mapperImpl: MoviesResultDataToDomainMapperImpl
    ): MoviesResultDataToDomainMapper

    @Binds
    fun bindMovieListDomainToUiMapperImpl_to_MovieListDomainToUiMapper(
        mapperImpl: MoviesResultDomainToUiMapperImpl
    ): MoviesResultDomainToUiMapper

    @Binds
    fun bindMovieDataEntityToDomainMapperImpl_to_MovieDataEntityToDomainMapper(
        mapperImpl: MovieDataEntityToDomainMapperImpl
    ): MovieDataEntityToDomainMapper

    @Binds
    fun bindMovieDomainEntityToUiMapperImpl_to_MovieDomainEntityToUiMapper(
        mapperImpl: MovieDomainEntityToUiMapperImpl
    ): MovieDomainEntityToUiMapper
}