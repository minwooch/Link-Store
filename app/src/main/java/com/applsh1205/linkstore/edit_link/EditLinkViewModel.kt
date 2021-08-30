package com.applsh1205.linkstore.edit_link

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applsh1205.linkstore.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditLinkViewModel : ViewModel() {
    private val _linkId = MutableLiveData<String>("")
    val url = MutableLiveData<String>("")
    val name = MutableLiveData<String>("")
    val finish = MutableLiveData<Boolean>(false)

    fun updateLinkId(id: String) {
        _linkId.value = id
        viewModelScope.launch {
            val link = withContext(Dispatchers.IO) {
                AppDatabase.getInstance().linkDao().getLink(id)
            }
            url.value = link.url
            name.value = link.name
        }
    }

    fun updateLink() {
        val id = _linkId.value
        val url = url.value
        val name = name.value
        if (id == null || url == null || name == null) {
            return
        }

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                AppDatabase.getInstance().linkDao().update(
                    id,
                    url,
                    name,
                    ""
                )
            }
            finish.value = true
        }

    }
}