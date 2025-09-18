package com.stelmusic.core.database.mapper

import com.stelmusic.core.database.model.TemplateEntity
import com.stelmusic.core.model.TemplateModel

fun TemplateModel.toEntity() = TemplateEntity(
    id = id,
    date = date
)

fun TemplateEntity.toModel() = TemplateModel(
    id = id,
    date = date
)