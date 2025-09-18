package com.stelmusic.core.data.repository

import com.stelmusic.core.database.dao.TemplateDao
import com.stelmusic.core.database.mapper.toEntity
import com.stelmusic.core.database.mapper.toModel
import com.stelmusic.core.database.model.TemplateEntity
import com.stelmusic.core.model.TemplateModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultTemplateRepository @Inject constructor(
    private val templateDao: TemplateDao
) : TemplateRepository {
    override fun getAllTemplate(): Flow<List<TemplateModel>> =
        templateDao.getAll().map { it.map(TemplateEntity::toModel) }

    override fun getTemplateById(id: String): Flow<TemplateModel> =
        templateDao.getById(id).map(TemplateEntity::toModel)

    override suspend fun upsertTemplate(template: TemplateModel) =
        templateDao.upsert(template.toEntity())

    override suspend fun deleteTemplate(id: String) =
        templateDao.deleteById(id)
}