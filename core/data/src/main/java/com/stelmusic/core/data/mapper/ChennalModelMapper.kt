package com.stelmusic.core.data.mapper

import com.stelmusic.core.data.model.Channel
import com.stelmusic.core.model.ChannelModel
import com.stelmusic.core.model.Thumbnail

fun Channel.toChannelModel() = ChannelModel(
    id = id,
    name = snippet.title,
    thumbnail = Thumbnail(
        defaultUrl = snippet.thumbnails["default"]?.url ?: "",
        mediumUrl = snippet.thumbnails["medium"]?.url ?: "",
        highUrl = snippet.thumbnails["high"]?.url ?: ""
    ),
    subscriberCount = statistics.subscriberCount,
    coverPlayListId = ""
)