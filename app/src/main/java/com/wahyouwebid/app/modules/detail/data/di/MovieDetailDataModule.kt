package com.wahyouwebid.app.modules.detail.data.di

import com.wahyouwebid.app.modules.detail.data.MovieDetailApiService
import com.wahyouwebid.app.modules.detail.data.MovieDetailDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.wahyouwebid.app.modules.detail.domain.MovieDetailRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class MovieDetailDataModule {
    
    @Provides
    fun provideDataSource(api: MovieDetailApiService): MovieDetailRepository {
        return MovieDetailDataRepository(api)
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): MovieDetailApiService {
        return retrofit.create(MovieDetailApiService::class.java)
    }

}