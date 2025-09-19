package com.stelmusic.core.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Thumbnail(
    val url: String,
    val width: Int? = null,
    val height: Int? = null
)