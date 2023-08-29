package com.wahyouwebid.app.modules.movie.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wahyouwebid.app.base.BaseResultState
import com.wahyouwebid.app.modules.movie.domain.MovieUseCase
import com.wahyouwebid.app.modules.movie.domain.model.MovieItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor( 
    private val useCase: MovieUseCase
) : ViewModel() {

    val nowPlaying: MutableLiveData<BaseResultState<List<MovieItem>>> by lazy {
        MutableLiveData()
    }

    val popular: MutableLiveData<BaseResultState<List<MovieItem>>> by lazy {
        MutableLiveData()
    }

    val topRated: MutableLiveData<BaseResultState<List<MovieItem>>> by lazy {
        MutableLiveData()
    }

    fun getNowPlaying() {
        useCase.getNowPlaying { result ->
            nowPlaying.postValue(result)
        }
    }

    fun getPopular() {
        useCase.getPopular { result ->
            popular.postValue(result)
        }
    }

    fun getTopRated() {
        useCase.getTopRated { result ->
            topRated.postValue(result)
        }
    }

    override fun onCleared() {
        super.onCleared()
        useCase.clearDisposable()
    }


}