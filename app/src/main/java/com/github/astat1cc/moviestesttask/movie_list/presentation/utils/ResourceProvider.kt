package com.github.astat1cc.moviestesttask.movie_list.presentation.utils

import android.content.Context
import androidx.annotation.StringRes

interface ResourceProvider {

    fun getString(@StringRes id: Int): String
}

class ResourceProviderImpl(private val context: Context) : ResourceProvider {

    override fun getString(id: Int): String = context.getString(id)
}