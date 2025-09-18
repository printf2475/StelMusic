package com.template.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "template_entity")
data class TemplateEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val date: String
)
