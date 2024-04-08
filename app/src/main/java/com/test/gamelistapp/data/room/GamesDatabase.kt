package com.test.gamelistapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.gamelistapp.data.model.entities.GameEntities
import com.test.gamelistapp.data.model.games.GameDetail

@Database(
    entities = [
        GameEntities::class
    ],
    version = 1,
    exportSchema = false
)

abstract class GamesDatabase : RoomDatabase() {

    abstract fun getGamesDao(): GameDao
}