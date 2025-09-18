package com.stelmusic.core.data.repository

import com.stelmusic.core.model.TemplateModel
import kotlinx.coroutines.flow.Flow

interface TemplateRepository {

    fun getAllTemplate(): Flow<List<TemplateModel>>

    fun getTemplateById(id: String): Flow<TemplateModel>

    suspend fun upsertTemplate(template: TemplateModel)

    suspend fun deleteTemplate(id: String)
}