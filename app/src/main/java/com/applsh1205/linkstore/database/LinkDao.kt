package com.applsh1205.linkstore.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LinkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(link: Link)

    @Query("SELECT * FROM links ORDER BY name")
    fun getLinks(): PagingSource<Int, Link>

}