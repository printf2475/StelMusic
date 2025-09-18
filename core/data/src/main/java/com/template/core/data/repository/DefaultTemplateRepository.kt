package com.template.core.data.repository

import com.template.core.database.dao.TemplateDao
import com.template.core.database.mapper.toEntity
import com.template.core.database.mapper.toModel
import com.template.core.database.model.TemplateEntity
import com.template.core.model.TemplateModel
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