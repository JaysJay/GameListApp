package com.test.gamelistapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.test.gamelistapp.data.model.games.Games
import com.test.gamelistapp.data.remote.GameApiService
import com.test.gamelistapp.data.room.GameDao
import com.test.gamelistapp.ui.helper.ListOfGamePagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepository @Inject constructor(
    private val api: GameApiService,
    private val gameDao: GameDao
) {
    companion object {
        private const val TAG = "GameRepository"
    }

    fun getAllGames(): Flow<PagingData<Games>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {ListOfGamePagingSource(api)}
        ).flow
    }

    //get data local
    //get data api
}