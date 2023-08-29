package com.wahyouwebid.app.modules.movie.data

import com.wahyouwebid.app.BuildConfig
import com.wahyouwebid.app.modules.movie.data.model.MovieResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface MovieApiService {

    @GET("movie/now_playing?api_key=${BuildConfig.apiKey}")
    fun getNowPlaying(): Observable<MovieResponse>

    @GET("movie/popular?api_key=${BuildConfig.apiKey}")
    fun getPopular(): Observable<MovieResponse>

    @GET("movie/300/recommendations?api_key=${BuildConfig.apiKey}")
    fun getTopRated(): Observable<MovieResponse>

}