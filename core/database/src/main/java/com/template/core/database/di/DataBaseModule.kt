package com.template.core.database.di

import android.content.Context
import androidx.room.Room
import com.template.core.database.TemplateDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun providesTemplateDataBase(
        @ApplicationContext context: Context,
    ): TemplateDataBase = Room.databaseBuilder(
        context,
        TemplateDataBase::class.java,
        "template-database",
    ).build()
}