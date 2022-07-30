package com.github.astat1cc.moviestesttask.core.di

import com.github.astat1cc.moviestesttask.core.di.modules.RetrofitModule
import com.github.astat1cc.moviestesttask.movie_list.di.MovieListModule
import com.github.astat1cc.moviestesttask.movie_list.presentation.MovieListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, MovieListModule::class])
interface AppComponent {

    fun inject(activity: MovieListActivity)
}