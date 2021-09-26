package com.applsh1205.linkstore.repository

import androidx.paging.*
import com.applsh1205.linkstore.database.LinkDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultLinkRepository(
    private val linkDao: LinkDao
) : LinkRepository {

    override suspend fun insert(url: String, name: String, description: String) {
        linkDao.insert(
            url,
            name,
            description
        )
    }

    override suspend fun update(id: String, url: String, name: String, description: String) {
        linkDao.update(id, url, name, description)
    }

    override fun getLink(id: String): Link {
        val linkEntry = linkDao.getLink(id)
        return Link(
            linkEntry.id,
            linkEntry.url,
            linkEntry.name,
            linkEntry.description
        )
    }

    override fun getLinks(): Flow<PagingData<Link>> {
        return Pager(
            config = PagingConfig(pageSize = 30)
        ) {
            linkDao.getLinks()
        }.flow.map { pagingData ->
            pagingData.map {
                Link(
                    id = it.id,
                    url = it.url,
                    name = it.name,
                    description = it.description
                )
            }
        }
    }
}