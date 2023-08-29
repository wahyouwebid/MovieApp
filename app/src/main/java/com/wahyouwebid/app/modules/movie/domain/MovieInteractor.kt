package com.wahyouwebid.app.modules.movie.domain

import com.wahyouwebid.app.base.BaseResultState
import com.wahyouwebid.app.modules.movie.domain.model.MovieItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MovieInteractor @Inject constructor(
    private val repository: MovieRepository,
    private val disposable: CompositeDisposable
): MovieUseCase {

    override fun getNowPlaying(callback: (BaseResultState<List<MovieItem>>) -> Unit) {
        repository.getNowPlaying()
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .map<BaseResultState<List<MovieItem>>> { BaseResultState.Success(it) }
            .onErrorReturn { BaseResultState.Error(it) }
            .startWithItem(BaseResultState.Loading)
            .subscribe(callback)
            .let { disposable.add(it) }
    }

    override fun getPopular(callback: (BaseResultState<List<MovieItem>>) -> Unit) {
        repository.getPopular()
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .map<BaseResultState<List<MovieItem>>> { BaseResultState.Success(it) }
            .onErrorReturn { BaseResultState.Error(it) }
            .startWithItem(BaseResultState.Loading)
            .subscribe(callback)
            .let { disposable.add(it) }
    }

    override fun getTopRated(callback: (BaseResultState<List<MovieItem>>) -> Unit) {
        repository.getTopRated()
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .map<BaseResultState<List<MovieItem>>> { BaseResultState.Success(it) }
            .onErrorReturn { BaseResultState.Error(it) }
            .startWithItem(BaseResultState.Loading)
            .subscribe(callback)
            .let { disposable.add(it) }
    }

    override fun clearDisposable() {
        disposable.clear()
    }
    
}