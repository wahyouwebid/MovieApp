package com.wahyouwebid.app.modules.movie.data.di

import com.wahyouwebid.app.modules.movie.data.MovieApiService
import com.wahyouwebid.app.modules.movie.data.MovieDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.wahyouwebid.app.modules.movie.domain.MovieRepository
import retrofit2.Retrofit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class MovieDataModule {
    
    @Provides
    fun provideDataSource(api: MovieApiService): MovieRepository {
        return MovieDataRepository(api)
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): MovieApiService {
        return retrofit.create(MovieApiService::class.java)
    }

}