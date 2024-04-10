package com.test.gamelistapp.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.test.gamelistapp.data.model.entities.GameEntities

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGames(game: GameEntities): Long

    @Query("SELECT * FROM favorite")
    fun getAllGames(): LiveData<List<GameEntities>>

    @Query("SELECT * FROM favorite WHERE id = :id")
    fun getGames(id: Int): LiveData<List<GameEntities>>

    @Delete
    suspend fun deleteGames(game: GameEntities)
}