package com.wahyouwebid.app.modules.movie.data

import com.wahyouwebid.app.modules.movie.domain.MovieRepository
import com.wahyouwebid.app.modules.movie.domain.model.MovieItem
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject


class MovieDataRepository @Inject constructor(
    private val api: MovieApiService
) : MovieRepository {

    override fun getNowPlaying(): Observable<List<MovieItem>> {
        return api.getNowPlaying().map { nowPlaying ->
            nowPlaying.results.map { it.toDomain() }
        }
    }

    override fun getPopular(): Observable<List<MovieItem>> {
        return api.getPopular().map { popular ->
            popular.results.map { it.toDomain() }
        }
    }

    override fun getTopRated(): Observable<List<MovieItem>> {
        return api.getTopRated().map { toRated ->
            toRated.results.map { it.toDomain() }
        }
    }

}