package com.wahyouwebid.app.base

sealed class BaseResultState<out T : Any> {

    data class Success<out T : Any>(val data: T) : BaseResultState<T>()

    data class Error(val error: Throwable) : BaseResultState<Nothing>()

    object Loading : BaseResultState<Nothing>()

}