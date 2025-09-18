package com.template.core.model

import java.util.UUID

data class TemplateModel(
    val id: String = UUID.randomUUID().toString(),
    val date: String = ""
)
