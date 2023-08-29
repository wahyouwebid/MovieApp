package com.wahyouwebid.app.modules.detail.domain

import com.wahyouwebid.app.base.BaseResultState
import com.wahyouwebid.app.modules.detail.domain.model.MovieDetailItem

interface MovieDetailUseCase {
    
    fun getDetail(
        id: Int?,
        callback : (BaseResultState<MovieDetailItem>) -> Unit
    )
    
    fun clearDisposable()
    
}