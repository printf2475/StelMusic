package com.stelmusic.core.data.di

import com.stelmusic.core.data.repository.DefaultTemplateRepository
import com.stelmusic.core.data.repository.TemplateRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsDefaultTemplateRepository(
        templateRepository: DefaultTemplateRepository
    ): TemplateRepository

}