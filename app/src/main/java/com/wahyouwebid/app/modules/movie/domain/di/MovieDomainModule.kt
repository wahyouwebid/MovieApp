package com.wahyouwebid.app.modules.movie.domain.di

import com.wahyouwebid.app.modules.movie.domain.MovieInteractor
import com.wahyouwebid.app.modules.movie.domain.MovieRepository
import com.wahyouwebid.app.modules.movie.domain.MovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.disposables.CompositeDisposable


@InstallIn(SingletonComponent::class)
@Module
class MovieDomainModule {

    @Provides
    fun provideInteractor(
        repository: MovieRepository,
        disposable: CompositeDisposable
    ): MovieUseCase {
        return MovieInteractor(repository, disposable)
    }
}