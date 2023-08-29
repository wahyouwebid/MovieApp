package com.wahyouwebid.app.modules.detail.data

import com.wahyouwebid.app.BuildConfig
import com.wahyouwebid.app.modules.detail.data.model.MovieDetailResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailApiService {

    @GET("movie/{id}?api_key=${BuildConfig.apiKey}")
    fun getDetail(
        @Path("id") id: Int?
    ): Observable<MovieDetailResponse>

}