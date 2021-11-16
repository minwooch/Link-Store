package com.applsh1205.linkstore.inject

import android.content.Context
import androidx.room.Room
import com.applsh1205.linkstore.database.AppDatabase
import com.applsh1205.linkstore.repository.DefaultLinkRepository
import com.applsh1205.linkstore.repository.LinkRepository
import dagger.Module
import dagger.Provides

@Module
object AppModule {
    @AppScope
    @Provides
    fun provideAppDatabase(applicationContext: Context): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "Link-DB.db"
        ).build()
    }

    @AppScope
    @Provides
    fun provideLinkRepository(appDatabase: AppDatabase): LinkRepository {
        return DefaultLinkRepository(appDatabase.linkDao())
    }
}