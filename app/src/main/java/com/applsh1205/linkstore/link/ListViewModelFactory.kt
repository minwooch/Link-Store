package com.applsh1205.linkstore.link

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.applsh1205.linkstore.database.AppDatabase
import com.applsh1205.linkstore.repository.DefaultLinkRepository

class ListViewModelFactory : ViewModelProvider.Factory {

    private val linkRepository = DefaultLinkRepository(AppDatabase.getInstance().linkDao())

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListViewModel(linkRepository) as T
    }
}