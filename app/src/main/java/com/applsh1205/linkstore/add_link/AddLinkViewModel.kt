package com.applsh1205.linkstore.add_link

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applsh1205.linkstore.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class AddLinkViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    val link = MutableStateFlow<String>("")
    val name = MutableStateFlow<String>("")
    val finish = MutableStateFlow<Boolean>(false)

    init {
        val url = savedStateHandle.get<String>("url")
        if (url == null) {
            finish.value = true
        } else {
            link.value = url
            viewModelScope.launch {
                val linkName = withContext(Dispatchers.IO) {
                    val connection = Jsoup.connect(url)
                    connection.userAgent("Mozilla/5.0 (Linux; Android 9; Mi A2 Lite) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Mobile Safari/537.36")
                    connection.referrer("http://www.google.com/")
                    val document = connection.get()
                    document.select("meta[property=og:title]").attr("content")
                }
                name.value = linkName
            }
        }
    }

    fun addLink() {
        val link = link.value
        val name = name.value

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                AppDatabase.getInstance().linkDao().insert(
                    link,
                    name,
                    ""
                )
            }
            finish.value = true
        }

    }
}