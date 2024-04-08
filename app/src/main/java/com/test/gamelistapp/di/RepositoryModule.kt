package com.test.gamelistapp.di

import com.test.gamelistapp.data.remote.GameApiService
import com.test.gamelistapp.data.repository.GameRepository
import com.test.gamelistapp.data.room.GameDao
import com.test.gamelistapp.utillity.Constant.API_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGameApi(
        client: OkHttpClient
    ): GameApiService {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .client(client)
//            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(GameApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideGameRepository(
        api: GameApiService,
        gameDao: GameDao
    ): GameRepository {
        return GameRepository(api, gameDao)
    }


}