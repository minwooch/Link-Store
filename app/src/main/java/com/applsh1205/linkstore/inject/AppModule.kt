package com.applsh1205.linkstore.inject

import android.content.Context
import androidx.room.Room
import com.applsh1205.linkstore.database.AppDatabase
import com.applsh1205.linkstore.repository.DefaultLinkRepository
import com.applsh1205.linkstore.repository.LinkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext applicationContext: Context): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "Link-DB.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideLinkRepository(appDatabase: AppDatabase): LinkRepository {
        return DefaultLinkRepository(appDatabase.linkDao())
    }
}