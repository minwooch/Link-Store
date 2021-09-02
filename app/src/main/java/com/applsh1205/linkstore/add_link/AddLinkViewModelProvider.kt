package com.applsh1205.linkstore.add_link

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddLinkViewModelProvider(private val url: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddLinkViewModel(url) as T
    }
}