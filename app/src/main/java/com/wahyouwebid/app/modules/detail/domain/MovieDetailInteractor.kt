package com.wahyouwebid.app.modules.detail.domain

import com.wahyouwebid.app.base.BaseResultState
import com.wahyouwebid.app.modules.detail.domain.model.MovieDetailItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MovieDetailInteractor @Inject constructor(
    private val repository: MovieDetailRepository,
    private val disposable: CompositeDisposable
): MovieDetailUseCase {

    override fun getDetail(
        id: Int?,
        callback: (BaseResultState<MovieDetailItem>) -> Unit
    ) {
        repository.getDetail(id)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .map<BaseResultState<MovieDetailItem>> { BaseResultState.Success(it) }
            .onErrorReturn { BaseResultState.Error(it) }
            .startWithItem(BaseResultState.Loading)
            .subscribe(callback)
            .let { disposable.add(it) }
    }

    override fun clearDisposable() {
        disposable.clear()
    }
    
}