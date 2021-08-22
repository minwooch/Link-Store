package com.applsh1205.linkstore.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Link::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun linkDao(): LinkDao

    companion object {

        private var instance: AppDatabase? = null

        fun initialize(context: Context) {
            instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "Link-DB.db"
            ).build()
        }

        fun getInstance(): AppDatabase {
            return instance!!
        }
    }
}