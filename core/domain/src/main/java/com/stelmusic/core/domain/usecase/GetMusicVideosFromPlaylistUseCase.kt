package com.stelmusic.core.domain.usecase

import com.stelmusic.core.data.repository.YoutubeRepository
import javax.inject.Inject

class GetMusicVideosFromPlaylistUseCase @Inject constructor(
    private val youtubeRepository: YoutubeRepository
) {
    operator fun invoke(
        playlistId: String,
    ) = youtubeRepository.getMusicVideosFromPlaylist(playlistId)
}