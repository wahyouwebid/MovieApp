package com.wahyouwebid.app.modules.detail.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wahyouwebid.app.base.BaseResultState
import com.wahyouwebid.app.modules.detail.domain.MovieDetailUseCase
import com.wahyouwebid.app.modules.detail.domain.model.MovieDetailItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MovieDetailViewModel @Inject constructor( 
    private val useCase: MovieDetailUseCase
) : ViewModel() {

    val detail: MutableLiveData<BaseResultState<MovieDetailItem>> by lazy {
        MutableLiveData()
    }

    fun getDetail(id: Int?) {
        useCase.getDetail(id) { result ->
            detail.postValue(result)
        }
    }

    override fun onCleared() {
        super.onCleared()
        useCase.clearDisposable()
    }
}