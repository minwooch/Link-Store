package com.applsh1205.linkstore.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Link::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun linkDao(): LinkDao

    companion object {

        private lateinit var applicationContext: Context

        fun initialize(context: Context) {
            applicationContext = context
        }

        private object Instance {
            val instance = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "Link-DB.db"
            ).build()
        }

        fun getInstance(): AppDatabase {
            return Instance.instance
        }
    }
}