package com.test.gamelistapp.data.remote

import com.test.gamelistapp.utillity.Constant.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameApiService {

    @GET("games")
    suspend fun getAllGames(
        @Query("api_key")
        apiKey: String = API_KEY,
        @Query("language")
        language: String = "en-US",
        @Query("append_to_response")
        appendToResponse: String = "credits,recommendations,videos"
    ): Response<String>
}