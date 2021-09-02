package com.applsh1205.linkstore.edit_link

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EditLinkViewModelFactory(private val id: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EditLinkViewModel(id) as T
    }
}