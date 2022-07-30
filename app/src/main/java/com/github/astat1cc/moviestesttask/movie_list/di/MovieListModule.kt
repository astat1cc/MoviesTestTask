package com.github.astat1cc.moviestesttask.movie_list.di

import android.content.Context
import com.github.astat1cc.moviestesttask.movie_list.data.remote.service.MovieListService
import com.github.astat1cc.moviestesttask.movie_list.presentation.utils.ResourceProvider
import com.github.astat1cc.moviestesttask.movie_list.presentation.utils.ResourceProviderImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [MovieListBindModule::class])
class MovieListModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideMovieListService(retrofit: Retrofit): MovieListService =
        retrofit.create(MovieListService::class.java)

    @Singleton
    @Provides
    fun provideResourceProvider(): ResourceProvider = ResourceProviderImpl(context)
}