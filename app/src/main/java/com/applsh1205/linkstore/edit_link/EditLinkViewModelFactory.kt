package com.applsh1205.linkstore.edit_link

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.applsh1205.linkstore.database.AppDatabase
import com.applsh1205.linkstore.repository.DefaultLinkRepository

class EditLinkViewModelFactory(
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle?
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    private val linkRepository = DefaultLinkRepository(AppDatabase.getInstance().linkDao())

    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return EditLinkViewModel(handle, linkRepository) as T
    }
}