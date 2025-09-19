package com.stelmusic.core.data.di

import com.stelmusic.core.data.repository.DefaultYoutubeRepository
import com.stelmusic.core.data.repository.YoutubeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsDefaultMusicRepository(
        musicRepository: DefaultYoutubeRepository
    ): YoutubeRepository

}