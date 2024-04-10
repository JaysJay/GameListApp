package com.test.gamelistapp.ui.helper

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.test.gamelistapp.data.model.games.Games
import com.test.gamelistapp.data.remote.GameApiService

class ListOfGamePagingSource(
    private val gameApiService: GameApiService
) : PagingSource<Int, Games>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Games> {
        return try {
            // Start page index is 1
            val nextPageNumber = params.key ?: 1
            val response = gameApiService.getAllGames(page = nextPageNumber, pageSize = 10)

            LoadResult.Page(
                data = response.body()?.results ?: emptyList(),
                prevKey = null,
                nextKey = if (response.body()?.next.isNullOrEmpty()) null else nextPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Games>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}