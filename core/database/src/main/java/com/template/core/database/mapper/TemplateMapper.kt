package com.template.core.database.mapper

import com.template.core.database.model.TemplateEntity
import com.template.core.model.TemplateModel

fun TemplateModel.toEntity() = TemplateEntity(
    id = id,
    date = date
)

fun TemplateEntity.toModel() = TemplateModel(
    id = id,
    date = date
)