package com.applsh1205.linkstore.add_link

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.applsh1205.linkstore.repository.LinkRepository
import javax.inject.Inject

class AddLinkViewModelFactory @Inject constructor(
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle?,
    private val linkRepository: LinkRepository
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return AddLinkViewModel(handle, linkRepository) as T
    }
}