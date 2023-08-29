package com.wahyouwebid.app.modules.detail.domain.di

import com.wahyouwebid.app.modules.detail.domain.MovieDetailInteractor
import com.wahyouwebid.app.modules.detail.domain.MovieDetailRepository
import com.wahyouwebid.app.modules.detail.domain.MovieDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.disposables.CompositeDisposable


@InstallIn(SingletonComponent::class)
@Module
class MovieDetailDomainModule {

    @Provides
    fun provideInteractor(
        repository: MovieDetailRepository,
        compositeDisposable: CompositeDisposable
    ): MovieDetailUseCase {
        return MovieDetailInteractor(repository, compositeDisposable)
    }

}