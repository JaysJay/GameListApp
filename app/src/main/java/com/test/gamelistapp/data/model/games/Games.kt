package com.test.gamelistapp.data.model.games

import com.google.gson.annotations.SerializedName

data class Games(
    @SerializedName("added")
    val added: Int,
    @SerializedName("added_by_status")
    val addedByStatus: AddedByStatus,
    @SerializedName("background_image")
    val backgroundImage: String,
    @SerializedName("esrb_rating")
    val esrbRating: EsrbRating,
    @SerializedName("id")
    val id: Int,
    @SerializedName("metacritic")
    val metacritic: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("platforms")
    val platforms: List<Platform>,
    @SerializedName("playtime")
    val playtime: Int,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("rating_top")
    val ratingTop: Int,
    @SerializedName("ratings")
    val ratings: List<Ratings>,
    @SerializedName("ratings_count")
    val ratingsCount: Int,
    @SerializedName("released")
    val released: String,
    @SerializedName("reviews_text_count")
    val reviewsTextCount: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("suggestions_count")
    val suggestionsCount: Int,
    @SerializedName("tba")
    val tba: Boolean,
    @SerializedName("updated")
    val updated: String
) {
    data class AddedByStatus(
        @SerializedName("beaten")
        val beaten: Int,
        @SerializedName("dropped")
        val dropped: Int,
        @SerializedName("owned")
        val owned: Int,
        @SerializedName("playing")
        val playing: Int,
        @SerializedName("toplay")
        val toplay: Int,
        @SerializedName("yet")
        val yet: Int
    )

    data class EsrbRating(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("slug")
        val slug: String
    )

    data class Platform(
        @SerializedName("platform")
        val platform: Platform,
        @SerializedName("released_at")
        val releasedAt: String,
        @SerializedName("requirements")
        val requirements: Requirements
    ) {
        data class Platform(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("slug")
            val slug: String
        )

        data class Requirements(
            @SerializedName("minimum")
            val minimum: String,
            @SerializedName("recommended")
            val recommended: String
        )
    }

    data class Ratings(
        @SerializedName("id")
        val id: Int,
        @SerializedName("title")
        val title: String,
        @SerializedName("count")
        val count: Int,
        @SerializedName("percent")
        val percent: String
    )
}