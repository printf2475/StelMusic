package com.stelmusic.core.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.stelmusic.core.data.api.YoutubeApiService
import com.stelmusic.core.data.model.PlaylistItem

class YoutubePagingSource(
    private val youtubeApiService: YoutubeApiService,
    private val playlistId: String
) : PagingSource<String, PlaylistItem>() {

    override fun getRefreshKey(state: PagingState<String, PlaylistItem>): String? {
        // 새로고침 시 초기 키를 반환하거나 null을 반환합니다.
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, PlaylistItem> {
        return try {
            // LoadParams에서 다음 페이지 토큰(nextPageToken)을 가져옵니다.
            val pageToken = params.key

            // API 호출
            val response = youtubeApiService.getMusicVideosFromPlaylist(
                playlistId = playlistId,
                pageToken = pageToken
            )

            LoadResult.Page(
                data = response.items,
                prevKey = null, // 이전 페이지는 없으므로 null
                nextKey = response.nextPageToken // 다음 페이지 토큰
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}