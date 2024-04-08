package com.test.gamelistapp.data.repository

import com.test.gamelistapp.data.remote.GameApiService
import com.test.gamelistapp.data.room.GameDao
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

    //get data local
    //get data api
}