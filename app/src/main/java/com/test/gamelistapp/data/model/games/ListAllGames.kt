package com.test.gamelistapp.data.model.games


import com.google.gson.annotations.SerializedName

data class ListAllGames(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String,
    @SerializedName("results")
    val results: List<Games>
)