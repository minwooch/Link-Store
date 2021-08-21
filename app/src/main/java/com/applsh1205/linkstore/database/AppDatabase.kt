package com.applsh1205.linkstore.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class AppDatabase: RoomDatabase() {



    companion object {

        private var instance: AppDatabase? = null

        private val lock = Object()

        fun getInstance(context: Context): AppDatabase {
            val _instance1 = instance
            if (_instance1 != null) {
                return _instance1
            }

            synchronized(lock) {
                val _instance2 = instance
                if (_instance2 != null)
                    return _instance2

                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "link-database"
                ).build()
                return instance!!
            }
        }
    }
}