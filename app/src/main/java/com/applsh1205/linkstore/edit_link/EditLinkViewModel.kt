package com.applsh1205.linkstore.edit_link

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applsh1205.linkstore.repository.LinkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EditLinkViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val linkRepository: LinkRepository
) : ViewModel() {
    private val _linkId = MutableStateFlow<String>("")
    val url = MutableStateFlow<String>("")
    val name = MutableStateFlow<String>("")
    val finish = MutableStateFlow<Boolean>(false)

    init {
        val id = savedStateHandle.get<String>("id")
        if (id == null) {
            finish.value = true
        } else {
            _linkId.value = id
            viewModelScope.launch {
                val link = withContext(Dispatchers.IO) {
                    linkRepository.getLink(id)
                }
                url.value = link.url
                name.value = link.name
            }
        }
    }

    fun updateLink() {
        val id = _linkId.value
        val url = url.value
        val name = name.value

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                linkRepository.update(
                    id,
                    url,
                    name,
                    ""
                )
            }
            finish.value = true
        }

    }

    fun deleteLink() {
        val id = _linkId.value

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                linkRepository.delete(id)
            }
            finish.value = true
        }
    }

}