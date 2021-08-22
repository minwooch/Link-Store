package com.applsh1205.linkstore.add_link

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applsh1205.linkstore.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class AddLinkViewModel : ViewModel() {
    val link = MutableLiveData<String>("")
    val name = MutableLiveData<String>("")
    val finish = MutableLiveData<Boolean>(false)

    fun updateLink(url: String) {
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

    fun addLink() {
        val link = link.value
        val name = name.value
        if (link == null || name == null) {
            return
        }

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