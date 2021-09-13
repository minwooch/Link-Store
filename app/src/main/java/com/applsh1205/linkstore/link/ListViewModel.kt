package com.applsh1205.linkstore.link

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.applsh1205.linkstore.database.AppDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map

class ListViewModel : ViewModel() {

    private val _browserLink = MutableStateFlow<String>("")
    val browserLink: StateFlow<String> = _browserLink
    private val _editLink = MutableStateFlow<String>("")
    val editLink: StateFlow<String> = _editLink

    val links = Pager(
        config = PagingConfig(pageSize = 30)
    ) {
        AppDatabase.getInstance().linkDao().getLinks()
    }.flow.map { pagingData ->
        pagingData.map {
            val item = LinkItem(
                id = it.id,
                url = it.url,
                name = it.name,
                description = it.description
            )
            item.onClick = {
                onClickLinkItem(it.url)
            }
            item.onLongClick = {
                onLongClickLinkItem(it.id)
            }
            item
        }
    }.cachedIn(viewModelScope)

    private fun onClickLinkItem(url: String) {
        _browserLink.value = url
    }

    fun clearBrowserLink() {
        _browserLink.value = ""
    }

    private fun onLongClickLinkItem(id: String) {
        _editLink.value = id
    }

    fun clearEditLink() {
        _editLink.value = ""
    }

}