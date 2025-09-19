package com.stelmusic.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.stelmusic.core.data.api.YoutubeApiService
import com.stelmusic.core.data.mapper.toChannelModel
import com.stelmusic.core.data.mapper.toMusicVideoModel
import com.stelmusic.core.data.paging.YoutubePagingSource
import com.stelmusic.core.model.ChannelModel
import com.stelmusic.core.model.MusicVideoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class DefaultYoutubeRepository @Inject constructor(
    private val youtubeApiService: YoutubeApiService
) : YoutubeRepository {

    override suspend fun getChannel(channelHandle: String): ChannelModel? =
        youtubeApiService.getChannel(channelHandle).items.map { it.toChannelModel() }.firstOrNull()


    override fun getMusicVideosFromPlaylist(
        playlistId: String
    ): Flow<PagingData<MusicVideoModel>> = Pager(
        config = PagingConfig(
            pageSize = 20, // 한 페이지에 로드할 아이템 수
            enablePlaceholders = false // 로딩 중 UI를 보여줄지 여부
        ),
        pagingSourceFactory = {
            YoutubePagingSource(
                youtubeApiService = youtubeApiService,
                playlistId = playlistId
            )
        }
    ).flow.map { it.map { it.toMusicVideoModel() } }
}