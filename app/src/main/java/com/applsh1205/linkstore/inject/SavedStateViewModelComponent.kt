package com.applsh1205.linkstore.inject

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Provider

@Subcomponent(modules = [SavedStateViewModelModule::class])
interface SavedStateViewModelComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance savedStateHandle: SavedStateHandle): SavedStateViewModelComponent
    }

    fun viewModelMap(): Map<Class<out ViewModel>, Provider<ViewModel>>
}