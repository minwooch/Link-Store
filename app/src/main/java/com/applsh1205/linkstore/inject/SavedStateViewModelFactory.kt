package com.applsh1205.linkstore.inject

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import dagger.hilt.EntryPoints
import javax.inject.Inject

class SavedStateViewModelFactory @Inject constructor(
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle?,
    private val savedStateViewModelComponentFactory: HiltSavedStateViewModelComponentBuilder
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        val component = savedStateViewModelComponentFactory.savedStateHandle(handle).build()
        val viewModelProvider = EntryPoints.get(component, HiltSavedStateViewModelEntryPoint::class.java)
            .viewModelMap()
            .get(modelClass) ?: throw RuntimeException("${modelClass}가 없음")

        return viewModelProvider.get() as T
    }
}