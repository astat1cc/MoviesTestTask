package com.github.astat1cc.moviestesttask.movie_list.presentation.viewmodel

import androidx.lifecycle.*
import com.github.astat1cc.moviestesttask.movie_list.domain.MoviesResultDomainToUiMapper
import com.github.astat1cc.moviestesttask.movie_list.domain.MovieListInteractor
import com.github.astat1cc.moviestesttask.movie_list.presentation.entities.MoviesResultUi
import com.github.astat1cc.moviestesttask.movie_list.presentation.entities.MovieUiEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieListViewModel(
    private val interactor: MovieListInteractor,
    private val mapper: MoviesResultDomainToUiMapper
) : ViewModel() {

    private val movieList = MutableLiveData<MoviesResultUi>()

    private val moviesFromAllPagesPages = mutableListOf<MovieUiEntity>()

    private val offset: Int
        get() = moviesFromAllPagesPages.size

    private val isFirstFetch: Boolean
        get() = moviesFromAllPagesPages.isEmpty()

    fun fetchMovieList() {
        viewModelScope.launch(Dispatchers.IO) {
            if (isFirstFetch) {
                movieList.postValue(MoviesResultUi.Loading)
            }
            val pageFetchingResult = interactor.fetchMovieList(offset).map(mapper)
            movieList.postValue(handleResult(pageFetchingResult))
        }
    }

    private fun handleResult(pageFetchingResult: MoviesResultUi) =
        if (pageFetchingResult is MoviesResultUi.Success) {
            moviesFromAllPagesPages += pageFetchingResult.movies
            MoviesResultUi.Success(moviesFromAllPagesPages)
        } else {
            pageFetchingResult
        }

    fun observe(owner: LifecycleOwner, observer: Observer<MoviesResultUi>) {
        movieList.observe(owner, observer)
    }

    class Factory @Inject constructor(
        private val interactor: MovieListInteractor,
        private val mapper: MoviesResultDomainToUiMapper
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            MovieListViewModel(interactor, mapper) as T
    }
}