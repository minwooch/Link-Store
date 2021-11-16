package com.applsh1205.linkstore.link

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.applsh1205.linkstore.repository.LinkRepository
import javax.inject.Inject

class ListViewModelFactory @Inject constructor(
    private val linkRepository: LinkRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListViewModel(linkRepository) as T
    }
}