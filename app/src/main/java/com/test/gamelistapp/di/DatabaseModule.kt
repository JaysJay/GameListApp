package com.test.gamelistapp.di

import android.content.Context
import androidx.room.Room
import com.test.gamelistapp.data.room.GameDao
import com.test.gamelistapp.data.room.GamesDatabase
import com.test.gamelistapp.data.room.MIGRATION_1_2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    private const val DATABASE_NAME = "list_game.db"

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext appContext: Context
    ) = Room.databaseBuilder(
        appContext,
        GamesDatabase::class.java,
        DATABASE_NAME
    ).addMigrations(
        MIGRATION_1_2
    ).build()

    @Singleton
    @Provides
    fun provideGameDao(
        db: GamesDatabase
    ): GameDao {
        return db.getGamesDao()
    }
}