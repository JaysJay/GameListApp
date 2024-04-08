package com.test.gamelistapp.data.model.entities

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "favorite",
    primaryKeys =["id"]
)
data class GameEntities (
    val id: Int,
    val genre: String,
    val name: String,
    val publisher: String,
    val image: String
)