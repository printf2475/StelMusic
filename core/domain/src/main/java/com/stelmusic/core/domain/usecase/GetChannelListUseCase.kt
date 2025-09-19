package com.stelmusic.core.domain.usecase

import com.stelmusic.core.data.repository.YoutubeRepository
import com.stelmusic.core.model.ChannelModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetChannelListUseCase @Inject constructor(
    private val youtubeRepository: YoutubeRepository
) {
    suspend operator fun invoke(
        channelHandleList: List<String>
    ): List<ChannelModel> = withContext(Dispatchers.IO) {
        return@withContext channelHandleList.map {
            async { youtubeRepository.getChannel(it) }
        }.awaitAll().filterNotNull()
    }
}