package com.github.astat1cc.moviestesttask.core

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.github.astat1cc.moviestesttask.core.di.AppComponent
import com.github.astat1cc.moviestesttask.core.di.DaggerAppComponent
import com.github.astat1cc.moviestesttask.movie_list.di.MovieListModule

class MovieApp : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .movieListModule(MovieListModule(this))
            .build()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MovieApp -> appComponent
        else -> applicationContext.appComponent
    }