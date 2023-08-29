package com.wahyouwebid.app.modules.movie.domain

import com.wahyouwebid.app.base.BaseResultState
import com.wahyouwebid.app.modules.movie.domain.model.MovieItem

interface MovieUseCase {
    
    fun getNowPlaying(callback : (BaseResultState<List<MovieItem>>) -> Unit)

    fun getPopular(callback : (BaseResultState<List<MovieItem>>) -> Unit)

    fun getTopRated(callback : (BaseResultState<List<MovieItem>>) -> Unit)

    fun clearDisposable()
    
}