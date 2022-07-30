package com.github.astat1cc.moviestesttask.movie_list.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.github.astat1cc.moviestesttask.core.appComponent
import com.github.astat1cc.moviestesttask.databinding.ActivityMovieListBinding
import com.github.astat1cc.moviestesttask.movie_list.presentation.adapter.MovieListAdapter
import com.github.astat1cc.moviestesttask.movie_list.presentation.entities.MovieUiEntity
import com.github.astat1cc.moviestesttask.movie_list.presentation.entities.MoviesResultUi
import com.github.astat1cc.moviestesttask.movie_list.presentation.viewmodel.MovieListViewModel
import javax.inject.Inject

class MovieListActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMovieListBinding.inflate(layoutInflater) }

    private val adapter by lazy {
        MovieListAdapter {
            viewModel.fetchMovieList()
        }
    }

    @Inject
    lateinit var viewModelFactory: MovieListViewModel.Factory
    private val viewModel by viewModels<MovieListViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        appComponent.inject(this)

        setupRecyclerView()

        viewModel.fetchMovieList()
        viewModel.observe(this) { result ->
            updateUi(result)
        }
    }

    private fun updateUi(result: MoviesResultUi) {
        when (result) {
            is MoviesResultUi.Loading -> showLoading()
            is MoviesResultUi.Success -> showSuccess(result.movies)
            is MoviesResultUi.Fail -> showFail(result.errorMessage)
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
    }

    private fun showLoading() {
        with(binding) {
            failFullscreen.root.visibility = View.GONE
            recyclerView.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        }
    }

    private fun showSuccess(movies: List<MovieUiEntity>) {
        with(binding) {
            progressBar.visibility = View.GONE
            failFullscreen.root.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }
        adapter.update(movies)
    }

    private fun showFail(errorMessage: String) {
        with(binding) {
            progressBar.visibility = View.GONE
            recyclerView.visibility = View.GONE
            failFullscreen.root.visibility = View.VISIBLE
            failFullscreen.messageTextView.text = errorMessage
            failFullscreen.tryAgainButton.setOnClickListener { viewModel.fetchMovieList() }
        }
    }
}