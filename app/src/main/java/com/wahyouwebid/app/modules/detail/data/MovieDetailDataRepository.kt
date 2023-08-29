package com.wahyouwebid.app.modules.detail.data

import com.wahyouwebid.app.modules.detail.domain.MovieDetailRepository
import com.wahyouwebid.app.modules.detail.domain.model.MovieDetailItem
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class MovieDetailDataRepository @Inject constructor(
    private val api: MovieDetailApiService
) : MovieDetailRepository {

    override fun getDetail(id: Int?): Observable<MovieDetailItem> {
        return api.getDetail(id).map { it.toDomain() }
    }

}