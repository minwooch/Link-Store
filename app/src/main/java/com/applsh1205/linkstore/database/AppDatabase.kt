package com.applsh1205.linkstore.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LinkEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun linkDao(): LinkDao

}