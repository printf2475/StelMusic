package com.template.core.database.di

import android.content.Context
import androidx.room.Room
import com.template.core.database.TemplateDataBase
import com.template.core.database.dao.TemplateDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {
    @Provides
    @Singleton
    fun providesTemplateDao(
        database: TemplateDataBase,
    ): TemplateDao = database.templateDao()

    @Provides
    @Singleton
    @Named("test_template_dao")
    fun providesTestTemplateDao(
        @ApplicationContext context: Context
    ): TemplateDao =
        Room.inMemoryDatabaseBuilder(
            context = context,
            klass = TemplateDataBase::class.java,
        ).build().templateDao()
}