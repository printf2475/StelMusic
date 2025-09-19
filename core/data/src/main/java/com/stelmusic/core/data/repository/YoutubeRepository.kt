package com.stelmusic.core.data.repository

import androidx.paging.PagingData
import com.stelmusic.core.model.ChannelModel
import com.stelmusic.core.model.MusicVideoModel
import kotlinx.coroutines.flow.Flow

interface YoutubeRepository {
    suspend fun getChannel(
        channelHandle: String
    ): ChannelModel?

    fun getMusicVideosFromPlaylist(
        playlistId: String
    ): Flow<PagingData<MusicVideoModel>>
}