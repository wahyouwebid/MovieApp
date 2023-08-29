package com.wahyouwebid.app.modules.detail.domain

import com.wahyouwebid.app.modules.detail.domain.model.MovieDetailItem
import io.reactivex.rxjava3.core.Observable

interface MovieDetailRepository {
    
    fun getDetail(id: Int?): Observable<MovieDetailItem>
    
}