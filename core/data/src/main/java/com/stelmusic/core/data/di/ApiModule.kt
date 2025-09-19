package com.stelmusic.core.data.di

import com.stelmusic.core.data.api.DefaultYoutubeApiService
import com.stelmusic.core.data.api.YoutubeApiService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface ApiModule {

    @Binds
    @Singleton
    fun bindsYoutubeApiService(
        youtubeApiService: DefaultYoutubeApiService
    ): YoutubeApiService
}