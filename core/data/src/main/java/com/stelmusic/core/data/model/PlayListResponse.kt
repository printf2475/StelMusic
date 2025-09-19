package com.stelmusic.core.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class PlaylistResponse(
    @SerialName("kind")
    val kind: String,
    @SerialName("etag")
    val etag: String,
    @SerialName("nextPageToken")
    val nextPageToken: String? = null,
    @SerialName("prevPageToken")
    val prevPageToken: String? = null,
    @SerialName("pageInfo")
    val pageInfo: PageInfo,
    @SerialName("items")
    val items: List<PlaylistItem>
)

@Serializable
data class PageInfo(
    @SerialName("totalResults")
    val totalResults: Int,
    @SerialName("resultsPerPage")
    val resultsPerPage: Int
)

@Serializable
data class PlaylistItem(
    @SerialName("kind")
    val kind: String,
    @SerialName("etag")
    val etag: String,
    @SerialName("id")
    val id: String,
    @SerialName("snippet")
    val snippet: Snippet,
    @SerialName("contentDetails")
    val contentDetails: ContentDetails? = null,
    @SerialName("status")
    val status: Status? = null
)

@Serializable
data class Snippet(
    @SerialName("publishedAt")
    val publishedAt: String, // ISO8601 datetime string
    @SerialName("channelId")
    val channelId: String,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("thumbnails")
    val thumbnails: Map<String, Thumbnail>,
    @SerialName("channelTitle")
    val channelTitle: String,
    @SerialName("videoOwnerChannelTitle")
    val videoOwnerChannelTitle: String,
    @SerialName("videoOwnerChannelId")
    val videoOwnerChannelId: String,
    @SerialName("playlistId")
    val playlistId: String,
    @SerialName("position")
    val position: Int,
    @SerialName("resourceId")
    val resourceId: ResourceId
)



@Serializable
data class ResourceId(
    @SerialName("kind")
    val kind: String,
    @SerialName("videoId")
    val videoId: String
)

@Serializable
data class ContentDetails(
    @SerialName("videoId")
    val videoId: String,
    @SerialName("startAt")
    val startAt: String? = null,
    @SerialName("endAt")
    val endAt: String? = null,
    @SerialName("note")
    val note: String? = null,
    @SerialName("videoPublishedAt")
    val videoPublishedAt: String? = null // ISO8601 datetime string
)

@Serializable
data class Status(
    @SerialName("privacyStatus")
    val privacyStatus: String
)
