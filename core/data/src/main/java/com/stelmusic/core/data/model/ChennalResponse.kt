package com.stelmusic.core.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChannelResponse(
    @SerialName("kind")
    val kind: String,
    @SerialName("etag")
    val eTag: String,
    @SerialName("pageInfo")
    val pageInfo: PageInfo,
    @SerialName("items")
    val items: List<Channel>
)

@Serializable
data class Channel(
    @SerialName("kind")
    val kind: String,
    @SerialName("etag")
    val eTag: String,
    @SerialName("id")
    val id: String,
    @SerialName("snippet")
    val snippet: ChannelSnippet,
    @SerialName("contentDetails")
    val contentDetails: ChannelContentDetails,
    @SerialName("statistics")
    val statistics: Statistics,
    @SerialName("topicDetails")
    val topicDetails: TopicDetails? = null,
    @SerialName("status")
    val status: ChannelStatus? = null,
    @SerialName("brandingSettings")
    val brandingSettings: BrandingSettings? = null,
    @SerialName("auditDetails")
    val auditDetails: AuditDetails? = null,
    @SerialName("contentOwnerDetails")
    val contentOwnerDetails: ContentOwnerDetails? = null,
    @SerialName("localizations")
    val localizations: Map<String, Localization>? = null
)

@Serializable
data class ChannelSnippet(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("customUrl")
    val customUrl: String? = null,
    @SerialName("publishedAt")
    val publishedAt: String,
    @SerialName("thumbnails")
    val thumbnails: Map<String, Thumbnail>,
    @SerialName("defaultLanguage")
    val defaultLanguage: String? = null,
    @SerialName("localized")
    val localized: Localized,
    @SerialName("country")
    val country: String? = null
)



@Serializable
data class Localized(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String
)

@Serializable
data class ChannelContentDetails(
    @SerialName("relatedPlaylists")
    val relatedPlaylists: RelatedPlaylists
)

@Serializable
data class RelatedPlaylists(
    @SerialName("likes")
    val likes: String? = null,
    @SerialName("favorites")
    val favorites: String? = null, // Deprecated
    @SerialName("uploads")
    val uploads: String
)

@Serializable
data class Statistics(
    @SerialName("viewCount")
    val viewCount: Long,
    @SerialName("subscriberCount")
    val subscriberCount: Long,
    @SerialName("hiddenSubscriberCount")
    val hiddenSubscriberCount: Boolean,
    @SerialName("videoCount")
    val videoCount: Long
)

@Serializable
data class TopicDetails(
    @SerialName("topicIds")
    val topicIds: List<String>? = null,
    @SerialName("topicCategories")
    val topicCategories: List<String>? = null
)

@Serializable
data class ChannelStatus(
    @SerialName("privacyStatus")
    val privacyStatus: String,
    @SerialName("isLinked")
    val isLinked: Boolean,
    @SerialName("longUploadsStatus")
    val longUploadsStatus: String,
    @SerialName("madeForKids")
    val madeForKids: Boolean,
    @SerialName("selfDeclaredMadeForKids")
    val selfDeclaredMadeForKids: Boolean
)

@Serializable
data class BrandingSettings(
    @SerialName("channel")
    val channel: BrandingChannel,
    @SerialName("watch")
    val watch: WatchSettings? = null
)

@Serializable
data class BrandingChannel(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("keywords")
    val keywords: String? = null,
    @SerialName("trackingAnalyticsAccountId")
    val trackingAnalyticsAccountId: String? = null,
    @SerialName("unsubscribedTrailer")
    val unsubscribedTrailer: String? = null,
    @SerialName("defaultLanguage")
    val defaultLanguage: String? = null,
    @SerialName("country")
    val country: String? = null
)

@Serializable
data class WatchSettings(
    @SerialName("textColor")
    val textColor: String? = null,
    @SerialName("backgroundColor")
    val backgroundColor: String? = null,
    @SerialName("featuredPlaylistId")
    val featuredPlaylistId: String? = null
)

@Serializable
data class AuditDetails(
    @SerialName("overallGoodStanding")
    val overallGoodStanding: Boolean,
    @SerialName("communityGuidelinesGoodStanding")
    val communityGuidelinesGoodStanding: Boolean,
    @SerialName("copyrightStrikesGoodStanding")
    val copyrightStrikesGoodStanding: Boolean,
    @SerialName("contentIdClaimsGoodStanding")
    val contentIdClaimsGoodStanding: Boolean
)

@Serializable
data class ContentOwnerDetails(
    @SerialName("contentOwner")
    val contentOwner: String,
    @SerialName("timeLinked")
    val timeLinked: String // ISO 8601 datetime
)

@Serializable
data class Localization(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String
)
