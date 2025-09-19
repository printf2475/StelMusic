package com.stelmusic.core.data.mapper

import com.stelmusic.core.data.model.PlaylistItem
import com.stelmusic.core.model.MusicVideoModel
import com.stelmusic.core.model.Thumbnail



internal fun PlaylistItem.toMusicVideoModel() = MusicVideoModel(
    id = id,
    title = this.snippet.title,
    thumbnail = Thumbnail(
        defaultUrl = this.snippet.thumbnails["default"]?.url ?: "",
        mediumUrl = this.snippet.thumbnails["medium"]?.url ?: "",
        highUrl = this.snippet.thumbnails["high"]?.url ?: ""
    ),
    publishedAt = this.snippet.publishedAt,
    channelTitle = this.snippet.channelTitle
)