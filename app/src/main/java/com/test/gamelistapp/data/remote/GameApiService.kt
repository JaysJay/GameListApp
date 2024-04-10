package com.test.gamelistapp.data.remote

import com.test.gamelistapp.data.model.games.ListAllGames
import com.test.gamelistapp.utillity.Constant.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameApiService {

    @GET("games")
    suspend fun getAllGames(
        @Query("key")
        apiKey: String = API_KEY,
        @Query("page")
        page: Int = 1,
        @Query("page_size")
        pageSize: Int = 10
    ): Response<ListAllGames>
}