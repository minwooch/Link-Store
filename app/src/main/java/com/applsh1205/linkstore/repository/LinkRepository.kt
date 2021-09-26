package com.applsh1205.linkstore.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface LinkRepository {
    suspend fun insert(url: String, name: String, description: String)
    suspend fun update(id: String, url: String, name: String, description: String)
    fun getLink(id: String): Link
    fun getLinks(): Flow<PagingData<Link>>
}