package com.template.core.data.di

import com.template.core.data.repository.DefaultTemplateRepository
import com.template.core.data.repository.TemplateRepository
import com.template.core.data.repository.TestTemplateRepository
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

    @Binds
    @Singleton
    @Named("test_template_repository")
    fun bindsTestTemplateRepository(
        templateRepository: TestTemplateRepository
    ): TemplateRepository

}