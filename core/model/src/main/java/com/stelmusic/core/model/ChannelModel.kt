package com.stelmusic.core.model

data class ChannelModel(
    val id: String,
    val name: String,
    val thumbnail: Thumbnail,
    val subscriberCount: Long,
    val coverPlayListId: String
)
