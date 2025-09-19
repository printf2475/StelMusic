package com.stelmusic.core.data.api

import com.stelmusic.core.data.BuildConfig
import com.stelmusic.core.data.model.ChannelResponse
import com.stelmusic.core.data.model.PlaylistResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import javax.inject.Inject

interface YoutubeApiService {
    suspend fun getChannel(
        channelHandle: String
    ): ChannelResponse

    suspend fun getMusicVideosFromPlaylist(
        playlistId: String,
        pageToken: String? = null
    ): PlaylistResponse
}

class DefaultYoutubeApiService @Inject constructor(
    val httpClient: HttpClient,
) : YoutubeApiService {

    override suspend fun getChannel(channelHandle: String): ChannelResponse =
        httpClient.get(BuildConfig.YOUTUBE_BASE_URL + "channels") {
            parameter("part", "snippet,contentDetails,statistics")
            parameter("forHandle", channelHandle)
            parameter("key", BuildConfig.YOUTUBE_API_KEY)
        }.body<ChannelResponse>()

    override suspend fun getMusicVideosFromPlaylist(
        playlistId: String,
        pageToken: String?
    ): PlaylistResponse = httpClient.get(BuildConfig.YOUTUBE_BASE_URL + "playlistItems") {
        parameter("part", "snippet,contentDetails")
        parameter("playlistId", playlistId)
        parameter("maxResults", 20)
        if (pageToken != null) {
            parameter("pageToken", pageToken)
        }
        parameter("key", BuildConfig.YOUTUBE_API_KEY)
    }.body<PlaylistResponse>()
}