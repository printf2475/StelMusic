package com.template.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.template.core.database.model.TemplateEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TemplateDao {
    @Query("SELECT * FROM template_entity")
    fun getAll(): Flow<List<TemplateEntity>>

    @Query("SELECT * FROM template_entity WHERE id = :id")
    fun getById(id: String): Flow<TemplateEntity>

    @Upsert
    fun upsert(templateEntityList: List<TemplateEntity>)

    @Upsert
    fun upsert(templateEntity: TemplateEntity)


    @Query("DELETE FROM template_entity WHERE id = :id")
    fun deleteById(id: String)
}