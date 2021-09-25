package com.applsh1205.linkstore.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import java.util.*

@Dao
interface LinkDao {

    suspend fun insert(url: String, name: String, description: String) {
        val link = LinkEntity(
            UUID.randomUUID().toString(),
            url,
            name,
            description
        )
        insert(link)
    }

    suspend fun update(id: String, url: String, name: String, description: String) {
        val link = LinkEntity(
            id,
            url,
            name,
            description
        )
        insert(link)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(link: LinkEntity)

    @Query("SELECT * FROM links ORDER BY name")
    fun getLinks(): PagingSource<Int, LinkEntity>

    @Query("SELECT * FROM links WHERE id = :id")
    fun getLink(id: String): LinkEntity

}