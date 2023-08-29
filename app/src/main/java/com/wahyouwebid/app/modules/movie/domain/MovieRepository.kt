package com.wahyouwebid.app.modules.movie.domain

import com.wahyouwebid.app.modules.movie.domain.model.MovieItem
import io.reactivex.rxjava3.core.Observable

interface MovieRepository {
    
    fun getNowPlaying(): Observable<List<MovieItem>>

    fun getPopular(): Observable<List<MovieItem>>

    fun getTopRated(): Observable<List<MovieItem>>

}