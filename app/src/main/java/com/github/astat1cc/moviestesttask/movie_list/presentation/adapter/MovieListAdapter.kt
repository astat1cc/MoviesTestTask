package com.github.astat1cc.moviestesttask.movie_list.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.astat1cc.moviestesttask.R
import com.github.astat1cc.moviestesttask.movie_list.presentation.entities.MovieUiEntity

class MovieListAdapter(
    private val endOfListCallback: () -> Unit
) : RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    fun update(movies: List<MovieUiEntity>) {
        differ.submitList(
            movies + MovieUiEntity.Loading
        )
    }

    private val diffCallback = object : DiffUtil.ItemCallback<MovieUiEntity>() {
        override fun areItemsTheSame(oldItem: MovieUiEntity, newItem: MovieUiEntity): Boolean =
            oldItem.hashCode() == newItem.hashCode()

        override fun areContentsTheSame(oldItem: MovieUiEntity, newItem: MovieUiEntity): Boolean =
            oldItem == newItem
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    override fun getItemViewType(position: Int): Int =
        when (differ.currentList[position]) {
            is MovieUiEntity.Success -> 0
            is MovieUiEntity.Loading -> 1
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        when (viewType) {
            0 -> MovieViewHolder.MovieItem(R.layout.item_movie.createView(parent))
            else -> MovieViewHolder.PaginationLoading(
                R.layout.item_loading.createView(parent),
                endOfListCallback
            )
        }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size

    private fun Int.createView(parent: ViewGroup): View =
        LayoutInflater.from(parent.context).inflate(this, parent, false)

    sealed class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        abstract fun bind(movie: MovieUiEntity)

        class MovieItem(view: View) : MovieViewHolder(view) {

            private val poster = itemView.findViewById<ImageView>(R.id.movie_image)
            private val title = itemView.findViewById<TextView>(R.id.titleTextView)
            private val description = itemView.findViewById<TextView>(R.id.descriptionTextView)

            override fun bind(movie: MovieUiEntity) {
                val success = movie as MovieUiEntity.Success
                Glide.with(itemView).load(success.imageUrl).into(poster)
                title.text = success.title
                description.text = success.description
            }
        }

        class PaginationLoading(
            view: View,
            private val endOfListReachedCallback: () -> Unit
        ) : MovieViewHolder(view) {

            override fun bind(movie: MovieUiEntity) {
                endOfListReachedCallback()
            }
        }
    }
}

