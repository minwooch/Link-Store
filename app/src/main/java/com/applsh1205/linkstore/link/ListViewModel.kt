package com.applsh1205.linkstore.link

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.applsh1205.linkstore.database.AppDatabase
import kotlinx.coroutines.flow.map

class ListViewModel : ViewModel() {

    private val _browserLink = MutableLiveData<String>("")
    val browserLink: LiveData<String> = _browserLink

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
            item
        }
    }.cachedIn(viewModelScope)

    private fun onClickLinkItem(url: String) {
        _browserLink.value = url
    }

    fun clearBrowserLink() {
        _browserLink.value = ""
    }

}